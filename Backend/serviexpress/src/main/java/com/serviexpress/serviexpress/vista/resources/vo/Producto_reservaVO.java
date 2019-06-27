package com.serviexpress.serviexpress.vista.resources.vo;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class Producto_reservaVO {
	private int productos_id_productos;
	private int pedidos_id_pedidos;
	private int cantidad;
	public int getProductos_id_productos() {
		return productos_id_productos;
	}
	public void setProductos_id_productos(int productos_id_productos) {
		this.productos_id_productos = productos_id_productos;
	}
	public int getPedidos_id_pedidos() {
		return pedidos_id_pedidos;
	}
	public void setPedidos_id_pedidos(int pedidos_id_pedidos) {
		this.pedidos_id_pedidos = pedidos_id_pedidos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}