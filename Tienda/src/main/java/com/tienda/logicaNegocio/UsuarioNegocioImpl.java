package com.tienda.logicaNegocio;


import com.tienda.accesodatos.DaoProducto;
import com.tienda.accesodatos.DaoProductoSqlite;
import com.tienda.entidades.Productos;

public class UsuarioNegocioImpl  implements UsuarioNegocio{
	private static final DaoProducto dao = new DaoProductoSqlite();

	@Override
	public Iterable<Productos> listadoProductos() {
		Iterable<Productos> productos = dao.obtenerTodos();
		return productos;
	}

	@Override
	public Productos datosProducto(Long id) {
		Productos producto = dao.obtenerPorId(id);
		return producto;
	}
	
}
