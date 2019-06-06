/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Tipo;
import com.serviexpress.serviexpress.negocio.repository.TipoRepository;

/**
 * Clase para definir los Tipos de la clase Tipos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class TipoService {
	private final TipoRepository tipoRepository;
	
	public TipoService(TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Tipo
	 * @param Tipo
	 * @return
	 */
	@Transactional
	public Tipo create(Tipo fam) {
		return this.tipoRepository.save(fam);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Tipo
	 * @param Tipo
	 * @return
	 */
	@Transactional
	public Tipo update(Tipo fam) {
		return this.tipoRepository.save(fam);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Tipo
	 * @param Tipo
	 * @return
	 */
	@Transactional
	public void delete(Tipo fam) {
		this.tipoRepository.delete(fam);
	}
	
	public Tipo findById_tipos(int id_familias){
		return this.tipoRepository.findById_tipos(id_familias);
	}
	
	public List<Tipo> findAll(){
		return this.tipoRepository.findAll();
	}
	
}
