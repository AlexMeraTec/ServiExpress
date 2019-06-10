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
@Table(name = "productos_reservas")
@NamedQuery(name = "Producto_reserva.findByProducto_reserva_id_reservas", query = "select p from Producto_reserva p where p.pedidos_id_pedidos = ?1")
public class Producto_reserva {

	@Column(name = "productos_id_productos")
	private int productos_id_productos;
	@Id
	@Column(name = "reservas_id_reservas")
	private int pedidos_id_pedidos;
	
	@Column(name = "cantidad")
	private int cantidad;
}