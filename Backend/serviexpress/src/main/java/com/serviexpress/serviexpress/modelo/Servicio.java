/**
 * 
 */
package com.serviexpress.serviexpress.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase representa a la tabla servicios
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "servicios")
@NamedQuery(name = "Servicio.findById_servicios", query = "select s from Servicio s where s.id_servicios = ?1")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id_servicios;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "activo")
	private boolean activo;
	
	@Column(name = "precio")
	private int precio;
	 
	public Servicio() {
		super();
	}
	public boolean getActivo() {
		return activo;
	}
}

