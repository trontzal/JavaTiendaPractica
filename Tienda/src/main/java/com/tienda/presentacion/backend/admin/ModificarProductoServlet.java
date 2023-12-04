package com.tienda.presentacion.backend.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tienda.logicaNegocio.AdminNegocio;
import com.tienda.logicaNegocio.AdminNegocioImpl;

@WebServlet("/admin/modificarProducto")
public class ModificarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final AdminNegocio an = new AdminNegocioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		Long id = Long.parseLong(sId);
		request.setAttribute("producto", an.datosProducto(id));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
