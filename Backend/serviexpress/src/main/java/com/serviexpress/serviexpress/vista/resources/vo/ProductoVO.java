package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class ProductoVO {
	
	private String id_productos; 
	private String nombre;
	private Date fecha_vencimiento;	
	private int proveedores_id_proveedor;	
	private int tipos_id_tipos;	
	private int familias_id_familias;
	private int precio_compra;
	private int precio_venta;
	private int stock;
	private int stock_critico;
	private boolean activo;

	public String getId_productos() {
		return id_productos;
	}
	public boolean getActivo() {
		return activo;
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
	public int getProveedores_id_proveedor() {
		return proveedores_id_proveedor;
	}
	public void setProveedores_id_proveedor(int proveedores_id_proveedor) {
		this.proveedores_id_proveedor = proveedores_id_proveedor;
	}
	public int getTipos_id_tipos() {
		return tipos_id_tipos;
	}
	public void setTipos_id_tipos(int tipos_id_tipos) {
		this.tipos_id_tipos = tipos_id_tipos;
	}
	public int getFamilias_id_familias() {
		return familias_id_familias;
	}
	public void setFamilias_id_familias(int familias_id_familias) {
		this.familias_id_familias = familias_id_familias;
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
	public void setId_productos(String id_productos) {
		this.id_productos = id_productos;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	/*
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
	}*/
	
}
