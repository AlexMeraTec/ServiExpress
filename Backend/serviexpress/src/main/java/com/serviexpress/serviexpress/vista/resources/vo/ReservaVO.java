package com.serviexpress.serviexpress.vista.resources.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**
 * @author arekkusu888
 *
 */
@Data
public class ReservaVO {
	private int id_reservas;
	private int empleados_id_personas;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date fecha;
	
	private String observaciones;
	private boolean se_atendio;
	private int clientes_id_personas;
	
	public boolean getSe_atendio() {
		return se_atendio;
	}
	public void setSe_atendio(boolean se_atendio) {
		this.se_atendio = se_atendio;
	}
	
}
