package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "reservas") //cambiar por reservas
@NamedQuery(name = "Reserva.findById_reservas", query = "select r from Reserva r where r.id_reservas = ?1")
public class Reserva {
	@Id
	@Column(name = "id_reservas")
	private int id_reservas;
	@Column(name = "empleados_id_personas")
	private int empleados_id_personas;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "se_atendio")
	private boolean se_atendio;
	@Column(name = "clientes_id_personas")
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
	public boolean isSe_atendio() {
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
