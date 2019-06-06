/**
 * 
 */
package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author arekkusu888
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="id_personas")
@Table(name = "empleados") //cambiar por reservas
@NamedQuery(name = "Empleado.findById_personas", query = "select e from Empleado e where e.id_personas = ?1")
public class Empleado{
	@Id
	@Column(name = "id_personas")
	private int id_personas;
	@Column(name = "nivel_acceso")
	private int nivel_acceso;
	
}
