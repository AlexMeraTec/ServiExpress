/**
 * 
 */
package com.serviexpress.serviexpress.modelo;

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
@Data
@Entity
@Table(name = "productos_pedidos")
@NamedQuery(name = "Producto_pedido.findByProducto_pedido_id_pedidos", query = "select p from Producto_pedido p where p.pedidos_id_pedidos = ?1 and p.productos_id_productos = ?1")
public class Producto_pedido {

	@Column(name = "productos_id_productos")
	private int productos_id_productos;
	@Id
	@Column(name = "pedidos_id_pedidos")
	private int pedidos_id_pedidos;
	
	@Column(name = "cantidad")
	private int cantidad;
}
