<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.tienda.logicaNegocio.*, com.tienda.entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>
	<h1>Listado de Productos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Fecha de Caducidad</th>
            </tr>
        </thead>
        <tbody>
            <% 
            UsuarioNegocioImpl negocio = new UsuarioNegocioImpl();
            Iterable<Productos> productos = negocio.listadoProductos();
            for (Productos p : productos) {
            %>
            <tr>
                <td><a href="detalleProducto.jsp?id=<%= p.getId() %>"><%= p.getId() %></a></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getPrecio() %></td>
                <td><%= p.getFechaCaducidad() != null ? p.getFechaCaducidad().toString() : "" %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>