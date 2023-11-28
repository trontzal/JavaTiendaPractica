package com.tienda.accesodatos;

import com.tienda.entidades.Productos;

public interface DaoProducto extends Dao<Productos> {
	Iterable<Productos> obtenerPorNombre(String nombreParcial);
}
