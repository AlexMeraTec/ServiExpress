package com.serviexpress.serviexpress.vista.resources.vo;

import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class EmpleadoVO {
	@JsonIgnore
	private int id_empleado;
	
	private int nivel_acceso;
	
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private PersonaVO personaEmpleado;

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getNivel_acceso() {
		return nivel_acceso;
	}

	public void setNivel_acceso(int nivel_acceso) {
		this.nivel_acceso = nivel_acceso;
	}

	public PersonaVO getPersonaEmpleado() {
		return personaEmpleado;
	}

	public void setPersonaEmpleado(PersonaVO personaEmpleado) {
		this.personaEmpleado = personaEmpleado;
	}
//	@JsonIgnore
//	private List<Reserva> reservasEmpleado;
}
