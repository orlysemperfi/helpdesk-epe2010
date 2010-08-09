<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
            prefix="c" %>

<html>
<head>
<title>GESTION DE REQUERIMIENTOS</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">
	function abre(){
		window.open("nuevo_req.jsp" , "ventana1" , "width=450,height=300,scrollbars=NO")
	}
</script>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" bgcolor="#E8E8E8">
<table cellpadding="0" cellspacing="0" width="100%" height="100%">
<tr><td align="center" valign="middle">
	<table cellpadding="0" cellspacing="0" class="stborder01" bgcolor="#DCDCDC">
	<tr><td width="895" height="40" align="center" bgcolor="#2E566F" class="sttxt_tit">SOLICITUD DE REQUERIMIENTOS
	<tr><td align="center"  bgcolor="#CEE2ED">
			<table cellpadding="0" cellspacing="0" class="sttxt01">
            <tr><td colspan="9" height="10">
			<tr><td width="1"><td width="316"><b>Usuario</b><td width="41"><td width="20">:<td width="41">
			  <td width="210">${nombres}
			  <td width="141"><strong>Id</strong>              
			  <td width="81">${codusuario}
			    
			  <td width="169">
			<tr><td colspan="9" height="10">
			<tr><td width="1"><td><b>Fecha y Hora</b><td width="41"><td>:<td width="41">
			  <td><input name="txt_fecha" type="text" class="sttxt01" id="txt_fecha">              
			  <td>              
			  <td>			    
			  <td width="169">
			<tr><td colspan="9" height="10">
			<tr><td width="1"><td colspan="7" align="left"><b>Historial de Requerimientos</b><td width="169">
			<tr><td colspan="9" height="10">
			<tr>
			  <td colspan="9">
        <table>
            <tr>
                <td>Año</td>
                <td>Asunto</td>
                <td>Descripción</td>
            </tr>
            <c:forEach items="${requerimientos}" var="req">
                <tr>
                    <td>${req.ano_ejercicio}</td>
                    <td>${req.txt_asunto}</td>
                    <td>${req.txt_descripcion}</td>
                </tr>
            </c:forEach>
        </table>
			<tr><td width="1">
			  <td colspan="7" align="left">
			    
			  <td width="169">
			<tr><td colspan="9" height="10">
			<tr><td width="1"><td colspan="7" align="right"><input name="cmd1" type="button" class="stbtn01" id="cmd1" value="Nuevo Requerimiento" onClick="abre();"><td width="169">
			<tr><td colspan="9" height="10">
			</table> 
	</table>
</table>
</body>
</html>
