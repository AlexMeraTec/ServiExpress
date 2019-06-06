/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Cliente;
import com.serviexpress.serviexpress.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios de la clase Persona
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente persona) {
		return this.clienteRepository.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de actualizar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente persona) {
		return this.clienteRepository.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de eliminar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public void delete(Cliente persona) {
		this.clienteRepository.delete(persona);
	}
	
	public Cliente findById_personas(int id_personas){
		return this.clienteRepository.findById_personas(id_personas);
	}
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
}
