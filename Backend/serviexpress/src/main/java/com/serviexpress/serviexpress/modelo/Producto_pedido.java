package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "productos_pedidos")
@IdClass(value = IdProducPedido.class)
@NamedQuery(name = "Producto_pedido.findByProducto_pedido_id_pedidos", query = "select pp from Producto_pedido pp where pp.id_pedidos = ?1 and pp.id_productos = ?1 ")
public class Producto_pedido {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_pedidos", updatable = false, nullable = false)
	private Pedido id_pedidos;
	@Id
	@ManyToOne
	@JoinColumn(name = "id_productos", updatable = false, nullable = false)
	private Producto id_productos;
	
	@Column(name = "cantidad")
	private int cantidad;
}