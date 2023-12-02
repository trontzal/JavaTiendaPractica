package com.tienda.presentacion.backend.admin;

import java.io.IOException;

import com.tienda.logicaNegocio.AdminNegocio;
import com.tienda.logicaNegocio.AdminNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/eliminar")
public class EliminarProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final AdminNegocio an = new AdminNegocioImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("id");

                long id = Long.parseLong(sId);
                an.eliminarProducto(id);
                // Redirige a la página de listado después de eliminar el producto
                response.sendRedirect(request.getContextPath() + "/admin/listaProductos");
    }
}
