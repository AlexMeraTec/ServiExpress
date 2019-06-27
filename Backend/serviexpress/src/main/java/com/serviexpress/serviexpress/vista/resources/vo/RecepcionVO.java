package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class RecepcionVO {
	private int id_recepcion;
	private int pedidos_id_pedidos;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private int cantidad;
	private int id_emp_recep;	
	private PedidoVO pedidovo;
	public int getId_recepcion() {
		return id_recepcion;
	}
	public void setId_recepcion(int id_recepcion) {
		this.id_recepcion = id_recepcion;
	}
	public int getPedidos_id_pedidos() {
		return pedidos_id_pedidos;
	}
	public void setPedidos_id_pedidos(int pedidos_id_pedidos) {
		this.pedidos_id_pedidos = pedidos_id_pedidos;
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
	public PedidoVO getPedidovo() {
		return pedidovo;
	}
	public void setPedidovo(PedidoVO pedidovo) {
		this.pedidovo = pedidovo;
	}
	
}