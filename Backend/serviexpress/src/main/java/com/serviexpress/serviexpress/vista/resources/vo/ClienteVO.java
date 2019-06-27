package com.serviexpress.serviexpress.vista.resources.vo;

import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class ClienteVO{
	@JsonIgnore
	private int id_cliente;
	
	private boolean natural_empresa;
	
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private PersonaVO personaCliente;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public boolean isNatural_empresa() {
		return natural_empresa;
	}

	public void setNatural_empresa(boolean natural_empresa) {
		this.natural_empresa = natural_empresa;
	}

	public PersonaVO getPersonaCliente() {
		return personaCliente;
	}

	public void setPersonaCliente(PersonaVO personaCliente) {
		this.personaCliente = personaCliente;
	}
	
//	@JsonIgnore
//	private List<Reserva> reservasCliente;
	
}
