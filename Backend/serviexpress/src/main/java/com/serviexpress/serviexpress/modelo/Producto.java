package com.serviexpress.serviexpress.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "productos")
@NamedQuery(name = "Producto.findById_productos", query = "select p from Producto p where p.id_productos = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
public class Producto {
	
	@Id
	@Column(name = "id_productos")
	private String id_productos; 
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_vencimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_vencimiento;
		
	@Column(name = "precio_compra")
	private int precio_compra;
	
	@Column(name = "precio_venta")
	private int precio_venta;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "stock_critico")
	private int stock_critico;
	
	@Column(name = "activo")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor", updatable = false, nullable = false) 
	private Proveedor id_proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_tipos", updatable = false, nullable = false) 
	private Tipo id_tipos;
	
	@ManyToOne
	@JoinColumn(name = "id_familias", updatable = false, nullable = false) 
	private Familia id_familias;

/*
	private Proveedor proveedor;
	
	private Familia familia;
	
	private Tipo tipo;
*/
	@OneToMany(mappedBy = "id_productos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_reserva> pProductoReserva;
	
	@OneToMany(mappedBy = "id_productos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_pedido> pProductoPedido;
	
	public boolean getActivo() {
		return activo;
	}
	
}