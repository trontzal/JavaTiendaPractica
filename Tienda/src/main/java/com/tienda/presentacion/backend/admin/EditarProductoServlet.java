//package com.tienda.presentacion.backend.admin;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//import com.tienda.entidades.Productos;
//import com.tienda.logicaNegocio.AdminNegocio;
//import com.tienda.logicaNegocio.AdminNegocioImpl;
//import com.tienda.logicaNegocio.UsuarioNegocio;
//import com.tienda.logicaNegocio.UsuarioNegocioImpl;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/admin/editarProducto")
//public class EditarProductoServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private static final UsuarioNegocio un = new UsuarioNegocioImpl();
//    private AdminNegocio an = new AdminNegocioImpl();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String sId = request.getParameter("id");
//
//        if (sId != null) {
//            Long id = Long.parseLong(sId);
//            Productos producto = un.datosProducto(id);
//            if (producto != null) {
//                request.setAttribute("producto", producto);
//            }
//        }
//
//        request.getRequestDispatcher("/WEB-INF/vistas/admin/editarProducto.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String sId = request.getParameter("id");
//        String nombre = request.getParameter("nombre");
//        String sPrecio = request.getParameter("precio");
//        String sFecha = request.getParameter("fecha");
//
//        Long id = sId.trim().isEmpty() ? null : Long.parseLong(sId);
//        BigDecimal precio = (sPrecio != null && !sPrecio.trim().isEmpty()) ? new BigDecimal(sPrecio) : null;
//        LocalDate fecha = (sFecha != null && !sFecha.isEmpty()) ? LocalDate.parse(sFecha) : null;
//
//        Productos producto = new Productos(id, nombre, precio, fecha);
//
//        if (id != null) {
//            // Actualizar el producto existente
//            an.editarProducto(producto); // Asume que tienes un método para actualizar en AdminNegocio
//        }
//
//        // Redirigir a la página de listado o a donde necesites ir
//        response.sendRedirect(request.getContextPath() + "/admin/listaProductos");
//    }
//}

