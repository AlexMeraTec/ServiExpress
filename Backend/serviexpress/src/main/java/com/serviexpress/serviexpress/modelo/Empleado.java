/**
 * 
 */
package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@Table(name = "empleados")
@DiscriminatorValue(value="e")
@NamedQuery(name = "Empleado.findById_personas", query = "select e from Empleado e where e.id_personas = ?1")
public class Empleado{
	@Id
	@Column(name = "id_personas")
	private int id_personas;
	@Column(name = "nivel_acceso")
	private int nivel_acceso;
/*
	@OneToOne(mappedBy = "id_personas", cascade = CascadeType.ALL)
	private Persona persona;
*/
}
