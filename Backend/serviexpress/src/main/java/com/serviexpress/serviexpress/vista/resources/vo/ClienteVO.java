package com.serviexpress.serviexpress.vista.resources.vo;

import javax.persistence.JoinColumn;
import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class ClienteVO{
	private int id_cliente;
	private boolean natural_empresa;
	
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private PersonaVO personaVO;
	
//	@JsonIgnore
//	private List<Reserva> reservasCliente;
	
}
