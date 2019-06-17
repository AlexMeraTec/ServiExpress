package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "vehiculos")
@NamedQuery(name = "Vehiculo.findByPatente", query = "select v from Vehiculo v where v.patente = ?1")
public class Vehiculo {
	@ManyToOne
	@JoinColumn(name = "id_cliente", updatable = false, nullable = false)
	private Cliente clienteReserva;
	
	@Id
	@Column(name = "patente")
	private String patente;
	
	@Column(name = "tipo")
	private char tipo;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "color")
    private String color;
	
	@Column(name = "anio")
    private Date anio;
	
	@Column(name = "motor")
    private String motor;
}