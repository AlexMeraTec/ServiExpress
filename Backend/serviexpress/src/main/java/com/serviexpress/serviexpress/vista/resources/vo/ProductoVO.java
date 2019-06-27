package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class ProductoVO {
	
	private String id_productos;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //esto permite la conversion del string entregado en la vista a formato DATE
	private Date fecha_vencimiento;
	private int id_proveedor;
	private int id_tipos;
	private int id_familias;
	private int precio_compra;
	private int precio_venta;
	private int stock;
	private int stock_critico;
	private boolean activo;
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public int getId_tipos() {
		return id_tipos;
	}
	public void setId_tipos(int id_tipos) {
		this.id_tipos = id_tipos;
	}
	public int getId_familias() {
		return id_familias;
	}
	public void setId_familias(int id_familias) {
		this.id_familias = id_familias;
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
	
}