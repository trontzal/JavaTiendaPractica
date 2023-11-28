package com.tienda.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Long Id);

	T insertar(T objeto);

	T modificar(T objeto);

	void borrar(Long Id);
}
