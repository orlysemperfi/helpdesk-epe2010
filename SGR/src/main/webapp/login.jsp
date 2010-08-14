<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style_form.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Sistema de Gestión de Requerimientos</title>
<script type="text/javascript" src="js/function.js"></script>
</head>
<body id="bg">
<link rel="shortcut icon" href="images/favicon.ico" />
<div id="wrap-logeo">
    <div id="content-logeo">
<div class="login">
	<div class="login-in">
		<div class="logo-name">
			<br /><h1 id="siglas-logeo"><center><img src="images/logo-a.png" /></center></h1>
			<h3><center>Ingreso de Usuarios</center></h3><br /><br />
		</div>
		<form id ="loginform" action="LoginController" name ="FrmDatos" method="post">
			<fieldset>
			<div class="row">
				<label for="username" class="username"></label>
				<input type="text" class="text" name="txt_usuario" id="username" required = "1" realname = "Name" />
			</div>
			<div class="row">
				<label for="pass" class="pass"></label>
				<input type="password" class="text" name="txt_password" id="pass" required = "0" realname = "Password" />
			</div>
			<div class="row">
				<button type="submit" class="loginbutn" title="Login" onfocus="this.blur();"></button>
			</div>
			</fieldset>
		</form>
	</div>
	</div>
	</div>
	</div>
</body>
</html>