package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Producto_pedido;

public interface Producto_pedidoRepository extends JpaRepository<Producto_pedido,Integer>{
	public Producto_pedido findByProducto_pedido_id_pedidos(int id_pedidos,String id_productos);
}
