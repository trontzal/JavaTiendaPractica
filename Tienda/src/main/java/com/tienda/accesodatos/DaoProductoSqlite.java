package com.tienda.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tienda.entidades.Productos;

public class DaoProductoSqlite {

	private static final String URL = "jdbc:sqlite:/sqlite/tienda.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver de sqlite", e);
		}
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha pòdido conectar a la base de datos", e);
		}
	}
	
	@Override
	public Iterable<Productos> obtenerTodos(){
		
	}

}
