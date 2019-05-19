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
	
	public boolean getActivo() {
		return activo;
	}
	
}

