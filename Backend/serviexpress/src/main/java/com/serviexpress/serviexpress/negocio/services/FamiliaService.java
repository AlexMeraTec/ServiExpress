/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Familia;
import com.serviexpress.serviexpress.negocio.repository.FamiliaRepository;

/**
 * Clase para definir los Familias de la clase Familias
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class FamiliaService {
	private final FamiliaRepository famRepository;
	
	public FamiliaService(FamiliaRepository famRepository) {
		this.famRepository = famRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Familia
	 * @param Familia
	 * @return
	 */
	@Transactional
	public Familia create(Familia fam) {
		return this.famRepository.save(fam);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Familia
	 * @param Familia
	 * @return
	 */
	@Transactional
	public Familia update(Familia fam) {
		return this.famRepository.save(fam);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Familia
	 * @param Familia
	 * @return
	 */
	@Transactional
	public void delete(Familia fam) {
		this.famRepository.delete(fam);
	}
	
	public Familia findById_familias(int id_familias){
		return this.famRepository.findById_familias(id_familias);
	}
	
	public List<Familia> findAll(){
		return this.famRepository.findAll();
	}
	
}
