<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "com.tienda.logicaNegocio.*, com.tienda.entidades.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de producto</title>
</head>
<body>
	<h1>Producto con id 9</h1>
	<%
	long id = Long.parseLong(request.getParameter("id"));
	
	UsuarioNegocioImpl negocio = new UsuarioNegocioImpl();
	Productos producto = negocio.datosProducto(id);
	%>
	
	<p>Nombre: <%= producto.getNombre() %><p>
</body>
</html>