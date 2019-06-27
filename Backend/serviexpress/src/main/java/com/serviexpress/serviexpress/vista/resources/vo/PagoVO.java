package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class PagoVO {
	
	private int id_pago;
	private Date fecha;
	private boolean boleta_factura;
	private int total_neto;
	private int descuento;
	private int total_final;
	private boolean anulada;
	private int id_reservas;
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
	public int getId_reservas() {
		return id_reservas;
	}
	public void setId_reservas(int id_reservas) {
		this.id_reservas = id_reservas;
	}
	
}