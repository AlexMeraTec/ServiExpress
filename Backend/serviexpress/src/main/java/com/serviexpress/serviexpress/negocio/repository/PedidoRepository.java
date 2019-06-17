package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Pedido;

/**
 * @author Arekkusu888
 *
 */
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	public Pedido findById_pedidos(int id_personas);
}
