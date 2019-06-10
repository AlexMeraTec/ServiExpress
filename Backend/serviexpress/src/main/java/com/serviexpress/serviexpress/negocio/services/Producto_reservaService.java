package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Producto_reserva;
import com.serviexpress.serviexpress.negocio.repository.Producto_reservaRepository;

/**
 * Clase para definir los Producto_reservas de la clase Producto_reservas
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class Producto_reservaService {
	private final Producto_reservaRepository prRepository;
	
	public Producto_reservaService(Producto_reservaRepository prRepository) {
		this.prRepository = prRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Producto_reserva
	 * @param Producto_reserva
	 * @return
	 */
	@Transactional
	public Producto_reserva create(Producto_reserva pp) {
		return this.prRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Producto_reserva
	 * @param Producto_reserva
	 * @return
	 */
	@Transactional
	public Producto_reserva update(Producto_reserva pp) {
		return this.prRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Producto_reserva
	 * @param Producto_reserva
	 * @return
	 */
	@Transactional
	public void delete(Producto_reserva pp) {
		this.prRepository.delete(pp);
	}
	
	public Producto_reserva findByProducto_reserva_id_reservas(String pedido_id_pedidos){
		return this.prRepository.findByProducto_reserva_id_reservas(pedido_id_pedidos);
	}
	
	public List<Producto_reserva> findAll(){
		return this.prRepository.findAll();
	}
	
}
