package com.tienda.presentacion.consola;

import com.tienda.accesodatos.DaoProducto;
import com.tienda.accesodatos.DaoProductoSqlite;
import com.tienda.entidades.Productos;

public class DaoProductoSqlitePrueba {

	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoSqlite();

//		dao.insertar(new Productos("Patatas"));

		for (Productos p : dao.obtenerTodos()) {
			System.out.println(p);

		}
			Productos producto = dao.obtenerPorId(2L);
			System.out.println(producto + "es el producto con id = 2");

	}

}
