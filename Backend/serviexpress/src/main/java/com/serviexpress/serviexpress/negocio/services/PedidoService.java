/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Pedido;
import com.serviexpress.serviexpress.negocio.repository.PedidoRepository;

/**
 * Clase para definir los Pedidos de la clase Pedidos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Pedido
	 * @param Pedido
	 * @return
	 */
	@Transactional
	public Pedido create(Pedido pdo) {
		return this.pedidoRepository.save(pdo);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Pedido
	 * @param Pedido
	 * @return
	 */
	@Transactional
	public Pedido update(Pedido pdo) {
		return this.pedidoRepository.save(pdo);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Pedido
	 * @param Pedido
	 * @return
	 */
	@Transactional
	public void delete(Pedido pdo) {
		this.pedidoRepository.delete(pdo);
	}
	
	public Pedido findById_pedidos(int id_pedido){
		return this.pedidoRepository.findById_pedidos(id_pedido);
	}
	
	public List<Pedido> findAll(){
		return this.pedidoRepository.findAll();
	}
	
}
