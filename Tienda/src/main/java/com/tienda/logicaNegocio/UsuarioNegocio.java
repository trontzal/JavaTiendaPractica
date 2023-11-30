package com.tienda.logicaNegocio;

import com.tienda.entidades.Productos;

public interface UsuarioNegocio {
	Iterable<Productos> listadoProductos();
	Productos datosProducto(Long id);
}
