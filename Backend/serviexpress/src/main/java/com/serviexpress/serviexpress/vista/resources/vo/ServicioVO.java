package com.serviexpress.serviexpress.vista.resources.vo;

import lombok.Data;

/**
 * Clase representa a la tabla servicios
 * @author arekkusu888
 */
@Data
public class ServicioVO {
	private int id_servicios;
	private String nombre;
	private boolean activo;
	private int precio;

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean getActivo() {
		return activo;
	}
	public int getId_servicios() {
		return id_servicios;
	}
	public void setId_servicios(int id_servicios) {
		this.id_servicios = id_servicios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}

