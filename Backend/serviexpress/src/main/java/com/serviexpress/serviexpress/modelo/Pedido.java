package com.serviexpress.serviexpress.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "pedidos")
@NamedQuery(name = "Pedido.findById_pedidos", query = "select p from Pedido p where p.id_pedidos = ?1")
public class Pedido {
	@Id
	@Column(name = "id_pedidos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedidos;

	@Column(name = "estado")
	private boolean estado;

	@Column(name = "empleados_id_personas")
	private int empleados_id_personas;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@OneToMany(mappedBy = "id_pedidos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_pedido> peProductoPedido;

	@OneToOne(mappedBy = "id_pedidos",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private Recepcion pRecepcion;

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

	public List<Producto_pedido> getPeProductoPedido() {
		return peProductoPedido;
	}

	public void setPeProductoPedido(List<Producto_pedido> peProductoPedido) {
		this.peProductoPedido = peProductoPedido;
	}

	public Recepcion getpRecepcion() {
		return pRecepcion;
	}

	public void setpRecepcion(Recepcion pRecepcion) {
		this.pRecepcion = pRecepcion;
	}
	
}
