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

@WebServlet("/admin/productos")
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
		// 1. Recoger los datos de la petición
		String sId = request.getParameter("id"); // name="id"
		String nombre = request.getParameter("nombre"); // name="nombre"
		String sPrecio = request.getParameter("precio");
		String sFecha = request.getParameter("fecha");

		// 2. Convertir la información
		Long id = sId.trim().length() == 0 ? null : Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);
		LocalDate fecha = LocalDate.parse(sFecha);

		// 3. Convertir en modelo
		Productos producto = new Productos(id, nombre, precio, fecha);

		// 4. Ejecutar lógica de negocio
		an.crearProducto(producto);

		// 5. Generar información para la vista

		// 6. Saltar a la vista
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
