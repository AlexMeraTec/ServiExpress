package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
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
	
	@Column(name = "reservas_id_reservas")
	private int reservas_id_reservas;
	
}