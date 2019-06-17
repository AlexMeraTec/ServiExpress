package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Recepcion;
import com.serviexpress.serviexpress.negocio.repository.RecepcionRepository;

/**
 * Clase para definir los Recepcions de la clase Recepcions
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class RecepcionService {
	private final RecepcionRepository recepRepository;
	
	public RecepcionService(RecepcionRepository recepRepository) {
		this.recepRepository = recepRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Recepcion
	 * @param Recepcion
	 * @return
	 */
	@Transactional
	public Recepcion create(Recepcion rr) {
		return this.recepRepository.save(rr);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Recepcion
	 * @param Recepcion
	 * @return
	 */
	@Transactional
	public Recepcion update(Recepcion rr) {
		return this.recepRepository.save(rr);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Recepcion
	 * @param Recepcion
	 * @return
	 */
	@Transactional
	public void delete(Recepcion rr) {
		this.recepRepository.delete(rr);
	}
	
	public Recepcion findById_recepcion(int id_servicios){
		return this.recepRepository.findById_recepcion(id_servicios);
	}
	
	public List<Recepcion> findAll(){
		return this.recepRepository.findAll();
	}
	
}
