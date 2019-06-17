package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "pagos")
@NamedQuery(name = "Pago.findById_pago", query = "select p from Pago p where p.id_pago = ?1")
public class Pago {
	@Id
	@Column(name = "id_pago")
	private int id_pago;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "boleta_factura")
	private boolean boleta_factura;
	
	@Column(name = "total_neto")
	private int total_neto;
	
	@Column(name = "descuento")
	private int descuento;
	
	@Column(name = "total_final")
	private int total_final;
	
	@Column(name = "anulada")
	private boolean anulada;
	
	@OneToOne
	@JoinColumn(name = "id_reservas", updatable = false, nullable = false)
	private Reserva id_reservas;
	
}