package com.serviexpress.serviexpress.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "empleados")	
@NamedQuery(name = "Empleado.findById_empleado", query = "select e,pe from Empleado e join e.personaEmpleado pe where e.id_empleado = ?1 and e.id_empleado = pe.id_personas")
public class Empleado{
	@Id
	@Column(name = "id_personas")
	private int id_empleado;
	@Column(name = "nivel_acceso")
	private int nivel_acceso;

	@OneToOne
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private Persona personaEmpleado;
	
	@OneToMany(mappedBy = "empleadoReserva",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private List<Reserva> reservasEmpleado;
}
