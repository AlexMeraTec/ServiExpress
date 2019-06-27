/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Persona;
import com.serviexpress.serviexpress.negocio.repository.PersonaRepository;

/**
 * Clase para definir los servicios de la clase Persona
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class PersonaService {
	private final PersonaRepository personaRepository;
	
	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Persona create(Persona persona) {
		return this.personaRepository.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de actualizar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Persona update(Persona persona) {
		return this.personaRepository.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de eliminar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public void delete(Persona persona) {
		this.personaRepository.delete(persona);
	}
	
	public Persona findById_personas(int id_personas){
		return this.personaRepository.findById_personas(id_personas);
	}
	
	public List<Persona> findAll(){
		return this.personaRepository.findAll();
	}
	@Transactional
	public int getLastId() {
		return this.personaRepository.getLastId();
	}
	
}
