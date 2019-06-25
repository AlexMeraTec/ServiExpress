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
	
//	@JsonIgnore
//	private List<Reserva> reservasEmpleado;
}
