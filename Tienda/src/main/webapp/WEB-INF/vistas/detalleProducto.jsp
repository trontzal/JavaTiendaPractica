<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "com.tienda.entidades.Productos"
    %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de producto</title>
</head>
<body>
	<c:if test="${producto != null }">
		<p>${producto.nombre }</p>
	</c:if>
</body>
</html>