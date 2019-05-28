package com.serviexpress.serviexpress.vista.resources.vo;


import java.util.Date;

import lombok.Data;


/**
 * @author arekkusu888
 *
 */
@Data
public class ReservaVO {
	private int id_reservas;
	private int empleados_id_personas;
	private Date fecha;
	private String observaciones;
	private boolean se_atendio;
	private int clientes_id_personas;
	
	public int getId_reservas() {
		return id_reservas;
	}
	public void setId_reservas(int id_reservas) {
		this.id_reservas = id_reservas;
	}
	public int getEmpleados_id_personas() {
		return empleados_id_personas;
	}
	public void setEmpleados_id_personas(int empleados_id_personas) {
		this.empleados_id_personas = empleados_id_personas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean getSe_atendio() {
		return se_atendio;
	}
	public void setSe_atendio(boolean se_atendio) {
		this.se_atendio = se_atendio;
	}
	public int getClientes_id_personas() {
		return clientes_id_personas;
	}
	public void setClientes_id_personas(int clientes_id_personas) {
		this.clientes_id_personas = clientes_id_personas;
	}
	
}
