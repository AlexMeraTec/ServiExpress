package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "recepciones")
@NamedQuery(name = "Recepcion.findById_recepcion", query = "select r from Recepcion r where r.id_recepcion = ?1")
public class Recepcion {

	@Id
	@Column(name = "id_recepcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_recepcion;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "id_emp_recep")
	private int id_emp_recep;
	
	@OneToOne
	@JoinColumn(name = "id_pedidos", updatable = false, nullable = false)
	private Pedido id_pedidos;

	public int getId_recepcion() {
		return id_recepcion;
	}

	public void setId_recepcion(int id_recepcion) {
		this.id_recepcion = id_recepcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_emp_recep() {
		return id_emp_recep;
	}

	public void setId_emp_recep(int id_emp_recep) {
		this.id_emp_recep = id_emp_recep;
	}

	public Pedido getId_pedidos() {
		return id_pedidos;
	}

	public void setId_pedidos(Pedido id_pedidos) {
		this.id_pedidos = id_pedidos;
	}
	
}
