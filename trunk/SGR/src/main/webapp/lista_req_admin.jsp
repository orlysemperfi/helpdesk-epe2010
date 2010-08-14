<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
            prefix="c" %>
			
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
<script type="text/javascript" src="js/uiscripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/uiscripts/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript">
$(function() {
	$('#date').datepicker({
		showOn: 'button',
		buttonImage: 'js/uiscripts/images/calendar.gif',
		changeMonth: true,
		changeYear: true
	});
});
</script>
<link rel="stylesheet" type="text/css" href="js/uiscripts/calendar.css"/>
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
		<center><form class="validform formulario" id="formulario" name="formulario" method="get" action="NuevoRequerimientoController">
		<fieldset>
			<legend><b> REGISTRO DE EVALUACION DE REQUERIMIENTO - ADMINISTRADOR </b></legend>
			<p>
				<label>Usuario</label> 
				<input name="nombre" type="text" class="required" id="nombre" style="width:50%" value='${nombres}'/>
				<input name="codigo" type="hidden" class="required" id="codigo" style="width:5%" value='${codusuario}'/>
			</p>
		</fieldset>
		</form>
		<br />
		<table width="98%" border="0" class="formulario">
			<thead>
				<tr>
					<th width="5%">Nro.</th>
					<th width="10%">Fec. Req</th>
					<th width="10%">Usuario</th>
					<th width="50%">Descripcion</th>
					<th width="15%">Estado</th>
					<th width="10%">Fec. Atenc.</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requerimientos}" var="req">
				<tr bgcolor="#DAE6F0" onmouseover="this.style.backgroundColor='#FFFFC0';this.style.cursor='hand';" onmouseout="this.style.backgroundColor='#DAE6F0';">
					<td>${req.cod_requerimiento}</td>
					<td>${req.fec_registro}</td>
					<td>${req.txt_nombre}</td>
					<td>${req.txt_descripcion}</td>
					<td>${req.txt_estado}</td>
					<td>${req.fec_estado}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
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