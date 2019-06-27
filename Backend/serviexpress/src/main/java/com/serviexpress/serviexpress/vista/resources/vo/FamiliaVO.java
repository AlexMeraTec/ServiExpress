package com.serviexpress.serviexpress.vista.resources.vo;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class FamiliaVO {
	private int id_familias;
	private String nombre;
	private boolean activa;
	public int getId_familias() {
		return id_familias;
	}
	public void setId_familias(int id_familias) {
		this.id_familias = id_familias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
}
