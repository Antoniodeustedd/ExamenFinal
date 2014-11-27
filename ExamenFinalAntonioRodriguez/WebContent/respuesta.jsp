<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de la operación</title>
</head>
<body>
<form action="Respuesta" method="get">
<% TarjetaCredito tarjetaCredito = (TarjetaCredito)request.getAttribute("tarjeta"); %>
<table>
    <tr>
      <th>Su saldo actual es:</th>
   </tr>
     <tr>
      <td><input type="text" name="cupoDisponible" value="<%=tarjetaCredito.getCupoDisponible() %>"/></td> 
  </tr>
</table>
 
 <input type="submit" value="Respuesta" id="respuesta" name="respuesta"/>
</form>
 <p><a href="index.html"  >Volver a Inicio</a></p>

</body>
</html>