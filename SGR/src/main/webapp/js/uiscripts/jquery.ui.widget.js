(function( $ ) {
var _remove = $.fn.remove;
$.fn.remove = function( selector, keepData ) {
	return this.each(function() {
		if ( !keepData ) {
			if ( !selector || $.filter( selector, [ this ] ).length ) {
				$( "*", this ).add( this ).each(function() {
					$( this ).triggerHandler( "remove" );
				});
			}
		}
		return _remove.call( $(this), selector, keepData );
	});
};
$.widget = function( name, base, prototype ) {
	var namespace = name.split( "." )[ 0 ],
		fullName;
	name = name.split( "." )[ 1 ];
	fullName = namespace + "-" + name;

	if ( !prototype ) {
		prototype = base;
		base = $.Widget;
	}
	$.expr[ ":" ][ fullName ] = function( elem ) {
		return !!$.data( elem, name );
	};
	$[ namespace ] = $[ namespace ] || {};
	$[ namespace ][ name ] = function( options, element ) {
		if ( arguments.length ) {
			this._createWidget( options, element );
		}
	};
	var basePrototype = new base();
	basePrototype.options = $.extend( {}, basePrototype.options );
	$[ namespace ][ name ].prototype = $.extend( true, basePrototype, {
		namespace: namespace,
		widgetName: name,
		widgetEventPrefix: $[ namespace ][ name ].prototype.widgetEventPrefix || name,
		widgetBaseClass: fullName
	}, prototype );
	$.widget.bridge( name, $[ namespace ][ name ] );
};
$.widget.bridge = function( name, object ) {
	$.fn[ name ] = function( options ) {
		var isMethodCall = typeof options === "string",
			args = Array.prototype.slice.call( arguments, 1 ),
			returnValue = this;
		options = !isMethodCall && args.length ?
			$.extend.apply( null, [ true, options ].concat(args) ) :
			options;
		if ( isMethodCall && options.substring( 0, 1 ) === "_" ) {
			return returnValue;
		}
		if ( isMethodCall ) {
			this.each(function() {
				var instance = $.data( this, name ),
					methodValue = instance && $.isFunction( instance[options] ) ?
						instance[ options ].apply( instance, args ) :
						instance;
				if ( methodValue !== instance && methodValue !== undefined ) {
					returnValue = methodValue;
					return false;
				}
			});
		} else {
			this.each(function() {
				var instance = $.data( this, name );
				if ( instance ) {
					if ( options ) {
						instance.option( options );
					}
					instance._init();
				} else {
					$.data( this, name, new object( options, this ) );
				}
			});
		}
		return returnValue;
	};
};
$.Widget = function( options, element ) {
	if ( arguments.length ) {
		this._createWidget( options, element );
	}
};
$.Widget.prototype = {
	widgetName: "widget",
	widgetEventPrefix: "",
	options: {
		disabled: false
	},
	_createWidget: function( options, element ) {
		this.element = $( element ).data( this.widgetName, this );
		this.options = $.extend( true, {},
			this.options,
			$.metadata && $.metadata.get( element )[ this.widgetName ],
			options );
		var self = this;
		this.element.bind( "remove." + this.widgetName, function() {
			self.destroy();
		});
		this._create();
		this._init();
	},
	_create: function() {},
	_init: function() {},
	destroy: function() {
		this.element
			.unbind( "." + this.widgetName )
			.removeData( this.widgetName );
		this.widget()
			.unbind( "." + this.widgetName )
			.removeAttr( "aria-disabled" )
			.removeClass(
				this.widgetBaseClass + "-disabled " +
				this.namespace + "-state-disabled" );
	},
	widget: function() {
		return this.element;
	},
	option: function( key, value ) {
		var options = key,
			self = this;
		if ( arguments.length === 0 ) {
			return $.extend( {}, self.options );
		}
		if  (typeof key === "string" ) {
			if ( value === undefined ) {
				return this.options[ key ];
			}
			options = {};
			options[ key ] = value;
		}
		$.each( options, function( key, value ) {
			self._setOption( key, value );
		});
		return self;
	},
	_setOption: function( key, value ) {
		this.options[ key ] = value;
		if ( key === "disabled" ) {
			this.widget()
				[ value ? "addClass" : "removeClass"](
					this.widgetBaseClass + "-disabled" + " " +
					this.namespace + "-state-disabled" )
				.attr( "aria-disabled", value );
		}
		return this;
	},
	enable: function() {
		return this._setOption( "disabled", false );
	},
	disable: function() {
		return this._setOption( "disabled", true );
	},
	_trigger: function( type, event, data ) {
		var callback = this.options[ type ];
		event = $.Event( event );
		event.type = ( type === this.widgetEventPrefix ?
			type :
			this.widgetEventPrefix + type ).toLowerCase();
		data = data || {};
		if ( event.originalEvent ) {
			for ( var i = $.event.props.length, prop; i; ) {
				prop = $.event.props[ --i ];
				event[ prop ] = event.originalEvent[ prop ];
			}
		}
		this.element.trigger( event, data );
		return !( $.isFunction(callback) &&
			callback.call( this.element[0], event, data ) === false ||
			event.isDefaultPrevented() );
	}
};
})( jQuery );