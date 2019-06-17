/**
 * 
 */
package com.serviexpress.serviexpress.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "id_servicios")
	private int id_servicios;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "activo")
	private boolean activo;
	
	@Column(name = "precio")
	private int precio;
	
	@OneToMany(mappedBy = "id_servicios",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Reserva_servicio> sReserva_servicio;
}

