/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Empleado;
import com.serviexpress.serviexpress.negocio.repository.EmpleadoRepository;

/**
 * Clase para definir los servicios de la clase Persona
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class EmpleadoService {
	private final EmpleadoRepository empReposiroty;
	
	public EmpleadoService(EmpleadoRepository empReposiroty) {
		this.empReposiroty = empReposiroty;
	}
	/**
	 * Metodo para realizar la operacion de guardar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Empleado create(Empleado persona) {
		return this.empReposiroty.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de actualizar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Empleado update(Empleado persona) {
		return this.empReposiroty.save(persona);
	}
	/**
	 * Metodo para realizar la operacion de eliminar una Persona
	 * @param servicio
	 * @return
	 */
	@Transactional
	public void delete(Empleado persona) {
		this.empReposiroty.delete(persona);
	}
	
	public Empleado findById_personas(int id_personas){
		return this.empReposiroty.findById_personas(id_personas);
	}
	
	public List<Empleado> findAll(){
		return this.empReposiroty.findAll();
	}
	
}
