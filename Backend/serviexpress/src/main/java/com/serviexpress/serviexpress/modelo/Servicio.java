/**
 * 
 */
package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "id_servicios")
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
	public int getId_servicios() {
		return id_servicios;
	}
	public void setId_servicios(int id_servicios) {
		this.id_servicios = id_servicios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}

