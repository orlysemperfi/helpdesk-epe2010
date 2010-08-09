<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
<!--
body {
	background-image: url(img/bg-clouds.png);
}
.Estilo1 {
	color: #333333;
	font-size: 18px;
}
.Estilo2 {font-size: 18px}
.Estilo11 {	color: #333333;
	font-size: 18px;
	font-weight: bold;
}
-->
    </style></head>
    <body>
        <h1 align="center">&nbsp;</h1>
        <h1 align="center"><span class="Estilo11">QWIQQER.COM</span></h1>
        <p align="center">&nbsp;</p>
        <h1 align="center" class="Estilo1">Mensaje del sistema</h1>
        <p align="center">&nbsp;</p>
        <p align="center" class="Estilo2">${mensaje}    </p>
  <p>  <br>
              <a href="crear_cuenta.jsp">Regresar</a>
    </p>
    </body>
</html>
