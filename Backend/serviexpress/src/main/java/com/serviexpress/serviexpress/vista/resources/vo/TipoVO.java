package com.serviexpress.serviexpress.vista.resources.vo;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class TipoVO {
	private int id_tipos;
	private String nombre;
	private boolean activo;
	public int getId_tipos() {
		return id_tipos;
	}
	public void setId_tipos(int id_tipos) {
		this.id_tipos = id_tipos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
