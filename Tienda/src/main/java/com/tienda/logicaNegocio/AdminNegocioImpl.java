package com.tienda.logicaNegocio;

import com.tienda.accesodatos.DaoProducto;
import com.tienda.accesodatos.DaoProductoSqlite;
import com.tienda.entidades.Productos;

public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio {
	private static final DaoProducto dao = new DaoProductoSqlite();

	@Override
	public Productos crearProducto(Productos producto) {
		return dao.insertar(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		dao.borrar(id);
	}
}
