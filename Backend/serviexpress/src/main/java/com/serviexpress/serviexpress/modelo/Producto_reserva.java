package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "productos_reservas")
@IdClass(value = IdProducReserva.class)
@NamedQuery(name = "Producto_reserva.findByProducto_reserva_id_reservas", query = "select pr from Producto_reserva pr where pr.id_reservas = ?1 and pr.id_productos = ?1 ")
public class Producto_reserva {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_reservas", updatable = false, nullable = false)
	private Reserva id_reservas;
	@Id
	@ManyToOne
	@JoinColumn(name = "id_productos", updatable = false, nullable = false)
	private Producto id_productos;
	
	@Column(name = "cantidad")
	private int cantidad;

	public Reserva getId_reservas() {
		return id_reservas;
	}

	public void setId_reservas(Reserva id_reservas) {
		this.id_reservas = id_reservas;
	}

	public Producto getId_productos() {
		return id_productos;
	}

	public void setId_productos(Producto id_productos) {
		this.id_productos = id_productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}