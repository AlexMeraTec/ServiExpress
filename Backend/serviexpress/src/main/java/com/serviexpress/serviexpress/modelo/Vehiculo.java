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
@NamedQuery(name = "Vehiculo.findByCliente", query = "select v from Vehiculo v join v.clienteVehiculo c where c.id_cliente = ?1")
public class Vehiculo {
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", updatable = false, nullable = false)
	private Cliente clienteVehiculo;
	
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

	public Cliente getClienteVehiculo() {
		return clienteVehiculo;
	}

	public void setClienteVehiculo(Cliente clienteVehiculo) {
		this.clienteVehiculo = clienteVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}
	
}