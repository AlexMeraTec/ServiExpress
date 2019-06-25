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
	
//	@JsonIgnore
//	private List<Reserva> reservasCliente;
	
}
