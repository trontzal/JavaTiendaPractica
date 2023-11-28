package com.tienda.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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
	
	public Productos(Long id, String nombre, LocalDate fechaCaducidad, BigDecimal precio) {
		this(id, nombre, precio, fechaCaducidad);
	}

	public Productos(String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
		this(null, nombre, fechaCaducidad, precio);
	}

	public Productos(String nombre, LocalDate fechaCaducidad, BigDecimal precio) {
		this(null, nombre, fechaCaducidad, precio);
	}

	public Productos(String nombre, BigDecimal precio) {
		this(null, nombre, null, precio);
	}

	public Productos(String nombre) {
		this(null, nombre, null, BigDecimal.ZERO);
	}

	public Productos() {
		this(null, "ANÓNIMO", null, BigDecimal.ZERO);
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

	@Override
	public int hashCode() {
		return Objects.hash(fechaCaducidad, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return Objects.equals(fechaCaducidad, other.fechaCaducidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fechaCaducidad="
				+ fechaCaducidad + "]";
	}

}
