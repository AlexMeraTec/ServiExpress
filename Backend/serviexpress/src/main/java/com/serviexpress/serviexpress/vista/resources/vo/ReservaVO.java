package com.serviexpress.serviexpress.vista.resources.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


/**
 * @author arekkusu888
 *
 */
@Data
public class ReservaVO {

	private int id_reservas;
	//@DateTimeFormat(pattern = "yyyy-mm-ddTHH:mm:ss")
	private LocalDateTime fecha;
	private String observaciones;
	private boolean se_atendio;
	private int id_cliente;
	private int id_empleado;
	
	@JsonIgnore
	private String nombreCliente;
	@JsonIgnore
	private String nombreEmpleado;
	
	private List<Integer> servicios;
	private List<String> productos;


	public boolean getSe_atendio(){return se_atendio;}

	public void setSe_atendio(boolean se_atendio) {this.se_atendio = se_atendio;}

	public int getId_reservas() {
		return id_reservas;
	}
	public void setId_reservas(int id_reservas) {
		this.id_reservas = id_reservas;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public List<Integer> getServicios() {
		return servicios;
	}
	public void setServicios(List<Integer> servicios) {
		this.servicios = servicios;
	}
	public List<String> getProductos() {
		return productos;
	}
	public void setProductos(List<String> productos) {
		this.productos = productos;
	}
}
