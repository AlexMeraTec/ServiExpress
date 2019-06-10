package com.serviexpress.serviexpress.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
/*
	private Proveedor proveedor;
	
	private Familia familia;
	
	private Tipo tipo;
*/
	
	public boolean getActivo() {
		return activo;
	}
	
}