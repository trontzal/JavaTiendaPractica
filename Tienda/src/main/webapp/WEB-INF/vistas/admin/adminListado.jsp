<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.tienda.entidades.Productos" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado administrador</title>
</head>
<body>
	<form action="/admin/listaProductos" method="post"> <!-- Formulario que rodea toda la tabla -->
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Fecha de caducidad</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos}" var="p">
					<tr>
						<td><a href="detalle?id=${p.id}">${p.id}</a></td>
						<td>${p.nombre}</td>
						<td>${p.precio}</td>
						<td>${p.fechaCaducidad}</td>
						<td>
							<a href="${pageContext.request.contextPath}/admin/crearProducto?id=10">Editar</a>
						</td>
						<td>
							<button formaction="${pageContext.request.contextPath}/admin/eliminar?id=${p.id}">Eliminar</button>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<a href="crearProducto">Crear nuevo</a>
</body>
</html>
