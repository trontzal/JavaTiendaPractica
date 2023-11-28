package com.tienda.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Productos {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate fechaCaducidad;

	public Productos(Long id, String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
		setId(id);
		setNombre(nombre);
		setFechaCaducidad(fechaCaducidad);
		setPrecio(precio);
	}

	public Productos(Productos productos) {
		this(productos.getId(), productos.getNombre(), productos.getPrecio(), productos.getFechaCaducidad());
	}

	// Setter y getters abajo
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

}
