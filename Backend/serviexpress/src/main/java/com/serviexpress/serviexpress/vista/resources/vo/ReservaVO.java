package com.serviexpress.serviexpress.vista.resources.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


/**
 * @author arekkusu888
 *
 */
@Data
public class ReservaVO {
	private int id_reservas;
	
	//@DateTimeFormat(pattern = "yyyy-mm-ddTHH:mm:ss")
	private LocalDateTime fecha;
	
	private String observaciones;
	
	private boolean se_atendio;

	private int id_cliente;
	private int id_empleado;
	
	public boolean getSe_atendio(){return se_atendio;}
	public void setSe_atendio(boolean se_atendio) {this.se_atendio = se_atendio;}
	
	
	private List<Integer> servicios;
	
	private List<String> productos;
}
