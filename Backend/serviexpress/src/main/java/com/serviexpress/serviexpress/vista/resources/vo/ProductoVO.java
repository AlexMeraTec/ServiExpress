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
	private int proveedores_id_proveedor;
	private int tipos_id_tipos;
	private int familias_id_familias;
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

	
}