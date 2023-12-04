package com.tienda.presentacion.backend.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.tienda.entidades.Productos;
import com.tienda.logicaNegocio.AdminNegocio;
import com.tienda.logicaNegocio.AdminNegocioImpl;
import com.tienda.logicaNegocio.UsuarioNegocio;
import com.tienda.logicaNegocio.UsuarioNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/crearProducto")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final UsuarioNegocio un = new UsuarioNegocioImpl();
	private AdminNegocio an = new AdminNegocioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			request.setAttribute("producto", un.datosProducto(id));
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/adminProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String sId = request.getParameter("id");
	    String nombre = request.getParameter("nombre");
	    String sPrecio = request.getParameter("precio");
	    String sFecha = request.getParameter("fecha");

	    Long id = sId.trim().isEmpty() ? null : Long.parseLong(sId);
	    BigDecimal precio = new BigDecimal(sPrecio);
	    LocalDate fecha = sFecha.isEmpty() ? null : LocalDate.parse(sFecha);

	    Productos producto = new Productos(id, nombre, precio, fecha);

	    if (id != null) {
	        // Actualizar el producto existente
	        an.editarProducto(producto); // Asume que tienes un método para actualizar en AdminNegocio
	    } else {
	        // Lógica de creación de un nuevo producto
	        an.crearProducto(producto); // Este es el código que ya tienes para crear
	    }

	    // Redirigir a la página de listado o a donde necesites ir
	    response.sendRedirect(request.getContextPath() + "/admin/listaProductos");
	}

}
