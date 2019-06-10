/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Pago;
import com.serviexpress.serviexpress.negocio.repository.PagoRepository;

/**
 * Clase para definir los Pagos de la clase Pagos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class PagoService {
	private final PagoRepository pagoRepository;
	
	public PagoService(PagoRepository pagoRepository) {
		this.pagoRepository = pagoRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Pago
	 * @param Pago
	 * @return
	 */
	@Transactional
	public Pago create(Pago pgo) {
		return this.pagoRepository.save(pgo);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Pago
	 * @param Pago
	 * @return
	 */
	@Transactional
	public Pago update(Pago pgo) {
		return this.pagoRepository.save(pgo);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Pago
	 * @param Pago
	 * @return
	 */
	@Transactional
	public void delete(Pago pgo) {
		this.pagoRepository.delete(pgo);
	}
	
	public Pago findById_pago(int id_pago){
		return this.pagoRepository.findById_pago(id_pago);
	}
	
	public List<Pago> findAll(){
		return this.pagoRepository.findAll();
	}
	
}
