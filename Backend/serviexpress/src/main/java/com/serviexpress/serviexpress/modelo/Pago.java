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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name = "fiado")
	private boolean fiado;
	
	@OneToOne
	@JoinColumn(name = "id_reservas", updatable = false, nullable = false)
	private Reserva id_reservas;

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isBoleta_factura() {
		return boleta_factura;
	}

	public void setBoleta_factura(boolean boleta_factura) {
		this.boleta_factura = boleta_factura;
	}

	public int getTotal_neto() {
		return total_neto;
	}

	public void setTotal_neto(int total_neto) {
		this.total_neto = total_neto;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getTotal_final() {
		return total_final;
	}

	public void setTotal_final(int total_final) {
		this.total_final = total_final;
	}

	public boolean isAnulada() {
		return anulada;
	}

	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}

	public Reserva getId_reservas() {
		return id_reservas;
	}

	public void setId_reservas(Reserva id_reservas) {
		this.id_reservas = id_reservas;
	}
	
}