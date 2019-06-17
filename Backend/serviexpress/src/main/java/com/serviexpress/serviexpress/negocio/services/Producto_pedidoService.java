package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Producto_pedido;
import com.serviexpress.serviexpress.negocio.repository.Producto_pedidoRepository;

/**
 * Clase para definir los Producto_pedidos de la clase Producto_pedidos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class Producto_pedidoService {
	private final Producto_pedidoRepository ppRepository;
	
	public Producto_pedidoService(Producto_pedidoRepository ppRepository) {
		this.ppRepository = ppRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Producto_pedido
	 * @param Producto_pedido
	 * @return
	 */
	@Transactional
	public Producto_pedido create(Producto_pedido pp) {
		return this.ppRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Producto_pedido
	 * @param Producto_pedido
	 * @return
	 */
	@Transactional
	public Producto_pedido update(Producto_pedido pp) {
		return this.ppRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Producto_pedido
	 * @param Producto_pedido
	 * @return
	 */
	@Transactional
	public void delete(Producto_pedido pp) {
		this.ppRepository.delete(pp);
	}
	
	public Producto_pedido findByProducto_pedido_id_pedidos(int pedido_id_pedidos,String id_productos){
		return this.ppRepository.findByProducto_pedido_id_pedidos(pedido_id_pedidos, id_productos);
	}
	
	public List<Producto_pedido> findAll(){
		return this.ppRepository.findAll();
	}
	
}
