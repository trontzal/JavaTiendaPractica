package com.tienda.presentacion.backend.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tienda.logicaNegocio.AdminNegocio;
import com.tienda.logicaNegocio.AdminNegocioImpl;

@WebServlet("/admin/listaProductos")
public class ListadoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final AdminNegocio an = new AdminNegocioImpl(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("productos", an.listadoProductos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/adminListado.jsp").forward(request, response);
	}

}
