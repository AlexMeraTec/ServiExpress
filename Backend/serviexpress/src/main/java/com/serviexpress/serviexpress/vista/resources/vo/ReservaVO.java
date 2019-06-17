package com.serviexpress.serviexpress.vista.resources.vo;

import java.time.LocalDateTime;
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

	private int ID_CLIENTE;
	private int ID_EMPLEADO;
	
	public boolean getSe_atendio(){return se_atendio;}
	public void setSe_atendio(boolean se_atendio) {this.se_atendio = se_atendio;}
	
}
