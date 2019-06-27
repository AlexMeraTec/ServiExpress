package com.serviexpress.serviexpress.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "reservas") //cambiar por reservas
@NamedQuery(
		name = "Reserva.findById_reservas", 
		query = "select r,cr,er from Reserva r join r.clienteReserva cr join r.empleadoReserva er where r.id_reservas = ?1")
@NamedQuery(
		name = "Reserva.findReservasByCliente", 
		query = "select r from Reserva r join r.clienteReserva cr where cr.id_cliente = ?1 ")
@NamedQuery(
		name = "Reserva.findReservasByEmpleado", 
		query = "select r from Reserva r join r.empleadoReserva er where er.id_empleado = ?1 ")

public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservas")
	private int id_reservas;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "se_atendio")
	private boolean se_atendio;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", updatable = false, nullable = false)
	private Cliente clienteReserva;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado", updatable = false, nullable = false) //name de joincolum debe ser el nobre de la id que se une con la de aqui segun el nombre que tiene en la otra clase
	private Empleado empleadoReserva;
	
	@OneToMany(mappedBy = "id_reservas",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Reserva_servicio> rReserva_servicio;
	
	@OneToMany(mappedBy = "id_reservas",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_reserva> rProductoReserva;
	
	@OneToOne(mappedBy = "id_reservas",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	private Pago pago;
	public boolean getSe_atendio() {
		return se_atendio;
	}
	public void setSe_atendio(boolean se_atendio) {
		this.se_atendio = se_atendio;
	}
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
	public Cliente getClienteReserva() {
		return clienteReserva;
	}
	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}
	public Empleado getEmpleadoReserva() {
		return empleadoReserva;
	}
	public void setEmpleadoReserva(Empleado empleadoReserva) {
		this.empleadoReserva = empleadoReserva;
	}
	public List<Reserva_servicio> getrReserva_servicio() {
		return rReserva_servicio;
	}
	public void setrReserva_servicio(List<Reserva_servicio> rReserva_servicio) {
		this.rReserva_servicio = rReserva_servicio;
	}
	public List<Producto_reserva> getrProductoReserva() {
		return rProductoReserva;
	}
	public void setrProductoReserva(List<Producto_reserva> rProductoReserva) {
		this.rProductoReserva = rProductoReserva;
	}
	public Pago getPago() {
		return pago;
	}
	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
}
