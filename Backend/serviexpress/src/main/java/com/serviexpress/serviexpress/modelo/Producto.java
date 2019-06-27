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
@NamedQuery(name = "Producto.findById_productos", query = "select p from Producto p join p.id_proveedor pr join p.id_tipos join p.id_familias where p.id_productos = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
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

	@OneToMany(mappedBy = "id_productos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_reserva> pProductoReserva;
	
	@OneToMany(mappedBy = "id_productos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Producto_pedido> pProductoPedido;
	
	public boolean getActivo() {
		return activo;
	}

	public String getId_productos() {
		return id_productos;
	}

	public void setId_productos(String id_productos) {
		this.id_productos = id_productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock_critico() {
		return stock_critico;
	}

	public void setStock_critico(int stock_critico) {
		this.stock_critico = stock_critico;
	}

	public Proveedor getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Proveedor id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public Tipo getId_tipos() {
		return id_tipos;
	}

	public void setId_tipos(Tipo id_tipos) {
		this.id_tipos = id_tipos;
	}

	public Familia getId_familias() {
		return id_familias;
	}

	public void setId_familias(Familia id_familias) {
		this.id_familias = id_familias;
	}

	public List<Producto_reserva> getpProductoReserva() {
		return pProductoReserva;
	}

	public void setpProductoReserva(List<Producto_reserva> pProductoReserva) {
		this.pProductoReserva = pProductoReserva;
	}

	public List<Producto_pedido> getpProductoPedido() {
		return pProductoPedido;
	}

	public void setpProductoPedido(List<Producto_pedido> pProductoPedido) {
		this.pProductoPedido = pProductoPedido;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}