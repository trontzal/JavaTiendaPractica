package com.tienda.logicaNegocio;

import com.tienda.entidades.Productos;

public interface AdminNegocio extends UsuarioNegocio{
	Productos crearProducto(Productos producto);
	Productos editarProducto(Productos producto);
	void eliminarProducto(Long id);
}
