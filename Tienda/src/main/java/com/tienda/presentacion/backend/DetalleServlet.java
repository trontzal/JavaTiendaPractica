package com.tienda.presentacion.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tienda.logicaNegocio.UsuarioNegocio;
import com.tienda.logicaNegocio.UsuarioNegocioImpl;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final UsuarioNegocio un = new UsuarioNegocioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		Long id = Long.parseLong(sId);
		request.setAttribute("producto" ,un.datosProducto(id));
		request.getRequestDispatcher("/WEB-INF/vistas/detalleProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
