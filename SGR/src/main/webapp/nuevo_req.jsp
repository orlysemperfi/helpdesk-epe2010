<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/light.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Gestión de Requerimientos</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js" ></script>
<script type="text/javascript" src="js/validate/reglas.js" ></script>
<script type="text/javascript" src="js/function.js"></script>
</head>
<body id="bg">
<link rel="shortcut icon" href="images/favicon.ico" />
<div id="wrap">
<div id="content-wrap2">
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
  </div>
</div>
<div id="header">
	<h1 id="siglas-sistema"><img src="images/logo-a.png" /></h1>
</div>
<div id="wrap">
    <div id="content-wrap">
		<center><form class="validform formulario" id="formulario" name="formulario" method="post" action="NuevoRequerimientoController">
		<fieldset>
			<legend><b> NUEVO REQUERIMIENTO </b></legend>
			<p>
				<label>Usuario</label> 
                                <input name="txt_nombre" type="text" class="required" id="nombre" style="width:50%" value='${nombres}'/>
                                <input name="txt_codigo" type="hidden" class="required" id="nombre" style="width:5%" value='${codigo}'/>
			</p>
			<p><label>Asunto</label>
				<input name="txt_asunto" type="text" class="required" id="asunto" style="width:50%"/>
			</p>
			<p><label>Detalle</label>
				<textarea name="txt_detalle" id="detalle" cols="70%"></textarea>
			</p>
			<p class="boton">
				<input name="submit" type="submit" class="btsimple" value="Enviar"/>
				<input name="Submit3" type="submit" class="btsimple" value="Cancelar"/>
			</p>
		</fieldset>
		</form>
		</center>
	</div>
	<div id="content-wrap1">
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>