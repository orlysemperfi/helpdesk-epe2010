<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>GESTION DE REQUERIMIENTOS</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css">
</head>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" bgcolor="#E8E8E8">
<table cellpadding="0" cellspacing="0" width="100%" height="100%">
<tr><td align="center" valign="middle">
        <br>
        <br>
        <br>
        <br>
	<table cellpadding="0" cellspacing="0" class="stborder01">
	<tr><td height="40" bgcolor="#2E566F" align="center" class="sttxt_tit">ACCESO A USUARIOS
	<tr><td align="center" bgcolor="#CEE2ED">
                <form name="FrmDatos" action="LoginController" method="POST">
			<table cellpadding="0" cellspacing="0" class="sttxt01">
            <tr><td colspan="7" height="10">
			<tr><td width="10">
				<td><b>Usuario</b>
				<td width="10">
				<td>:
				<td width="10">
				<td><input name="txt_usuario" type="text" class="sttxt01">
				<td width="10">
                        <tr><td colspan="7" height="10">
                        <tr><td width="10">
                                <td><b>Contraseña</b>
                                <td width="10">
                                <td>:
                                <td width="10">
                                <td><input name="txt_password" type="text" class="sttxt01" id="txt_contrasena">
                                <td width="10">
                        <tr><td colspan="7" height="10">
                        <tr><td colspan="7" align="center">
				<input name="cmd1" type="submit" class="stbtn01" id="cmd1" value="Aceptar" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="cmd2" type="button" class="stbtn01" id="cmd2" value="Cancelar" />
		    <tr><td colspan="7" height="10">
			</table>
                </form>
	</table>
</table>
</body>
</html>

