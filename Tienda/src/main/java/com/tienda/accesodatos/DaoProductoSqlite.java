package com.tienda.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.tienda.entidades.Productos;

public class DaoProductoSqlite implements DaoProducto {

	private static final String URL = "jdbc:sqlite:/sqlite/tienda/tienda.db";
	private static final String SQL_SELECT = "SELECT id, nombre, precio, fecha_caducidad FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, fecha_caducidad) VALUES (?,?,?)";

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
	public Iterable<Productos> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var productos = new ArrayList<Productos>();
			Productos producto;
			LocalDate fecha;
			String sFecha;

			while (rs.next()) {
				sFecha = rs.getString("fecha_caducidad");
				fecha = sFecha != null ? LocalDate.parse(sFecha) : null;

				producto = new Productos(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), fecha);
				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Productos obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();
			Productos producto = null;
			LocalDate fecha;
			String sFecha;

			if (rs.next()) {
				sFecha = rs.getString("fecha_caducidad");
				fecha = sFecha != null ? LocalDate.parse(sFecha) : null;

				producto = new Productos(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), fecha);
			}

			return producto;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido obtener el registro " + id, e);
		}
	}

	@Override
	public Productos insertar(Productos producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());

			LocalDate fecha = producto.getFechaCaducidad();
			String sFecha = fecha == null ? null : fecha.toString();

			pst.setString(3, sFecha);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new RuntimeException("La inserción ha devuelto " + numeroRegistrosModificados);
			}

			return producto;
		} catch (SQLException e) {
			throw new RuntimeException("No se han podido insertar el registro " + producto, e);
		}
	}

	@Override
	public Productos modificar(Productos objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Productos> obtenerPorNombre(String nombreParcial) {
		// TODO Auto-generated method stub
		return null;
	}

}
