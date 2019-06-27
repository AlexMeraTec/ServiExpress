package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class PedidoVO {
	private int id_pedidos;
	private boolean estado;
	private int empleados_id_personas;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	public int getId_pedidos() {
		return id_pedidos;
	}
	public void setId_pedidos(int id_pedidos) {
		this.id_pedidos = id_pedidos;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getEmpleados_id_personas() {
		return empleados_id_personas;
	}
	public void setEmpleados_id_personas(int empleados_id_personas) {
		this.empleados_id_personas = empleados_id_personas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
