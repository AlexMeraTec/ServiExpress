package com.serviexpress.serviexpress.vista.resources.vo;

import javax.persistence.JoinColumn;
import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class EmpleadoVO {
	private int id_empleado;
	private int nivel_acceso;
	
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private PersonaVO personaVO;
	
//	@JsonIgnore
//	private List<Reserva> reservasEmpleado;
}
