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
/*
@Data
@Entity
@Table(name = "productos")
*/
@NamedQuery(name = "Producto.findById_productos", query = "select p from producto p where p.id_productos = ?1")
public class Producto {
	/*
	@Id
	@Column(name = "id_productos")
	private String id_productos; 
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_vencimiento")
	private Date fecha_vencimiento;
	
	@Column(name = "proveedores_id_proveedor")
	private int proveedores_id_proveedor;
	
	@Column(name = "tipos_id_tipos")
	private int tipos_id_tipos;
	
	@Column(name = "familias_id_familias")
	private int familias_id_familias;
	
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

	public Producto() {
		super();
	}
	
	public String getId_productos() {
		return id_productos;
	}
	public boolean getActivo() {
		return activo;
	}
	
	public Producto
	(
		String nombre, 
		Date fecha_vencimiento, 
		int proveedores_id_proveedor, 
		int tipos_id_tipos,
		int familias_id_familias, 
		int precio_compra, 
		int precio_venta, 
		int stock, 
		int stock_critico,
		boolean activo
	){	
		super();
		this.nombre = nombre;
		this.fecha_vencimiento = fecha_vencimiento;
		this.proveedores_id_proveedor = proveedores_id_proveedor;
		this.tipos_id_tipos = tipos_id_tipos;
		this.familias_id_familias = familias_id_familias;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.stock = stock;
		this.stock_critico = stock_critico;
		this.activo = activo;
	}
	*/
	
}