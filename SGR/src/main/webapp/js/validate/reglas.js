$.validator.setDefaults({
	submitHandler: function() { submit(); }
});
$().ready(function() {
	$("#formulario,#formulario1").validate({
		rules: {
			dni: {
				required: true,
				minlength: 8
			},
			agree: "required"
		},
		messages: {
			firstname: "Please enter your firstname",
			lastname: "Please enter your lastname",
			dni: {
				required: "Ingrese un DNI",
				minlength: "Deben ser 8 números"
			}
		}
	});
});
jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-z-Ñ-ñ-á-é-í´-ó-ú' ']+$/i.test(value);
}, "Solamente ingrese Texto"); 
var nav4 = window.Event ? true : false;
function decimal(evt){
var key = nav4 ? evt.which : evt.keyCode;
return (key <= 13 || key == 46 || key == 37 || key == 39 || (key >= 48 && key <= 57));
}
function acceptNum(evt){
var key = nav4 ? evt.which : evt.keyCode;
return (key <= 13 || key == 37 || key == 39 || (key >= 48 && key <= 57));
}