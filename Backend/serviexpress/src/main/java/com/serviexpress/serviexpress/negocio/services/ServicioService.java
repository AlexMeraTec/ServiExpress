/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Servicio;
import com.serviexpress.serviexpress.negocio.repository.ServicioRepository;

/**
 * Clase para definir los servicios de la clase servicios
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class ServicioService {
	private final ServicioRepository servicioRepository;
	
	public ServicioService(ServicioRepository servicioRepository) {
		this.servicioRepository = servicioRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Servicio create(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Servicio update(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public void delete(Servicio servicio) {
		this.servicioRepository.delete(servicio);
	}
	
	public Servicio findById_servicios(int id_servicios){
		return this.servicioRepository.findById_servicios(id_servicios);
	}
	
	public List<Servicio> findAll(){
		return this.servicioRepository.findAll2();
	}
	public List<Servicio> findInactivos(){
		return this.servicioRepository.findAll3();
	}
	
}
