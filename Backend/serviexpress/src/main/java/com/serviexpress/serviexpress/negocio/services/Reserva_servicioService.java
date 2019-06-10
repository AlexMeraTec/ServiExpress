package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Reserva_servicio;
import com.serviexpress.serviexpress.negocio.repository.Reserva_servicioRepository;

/**
 * Clase para definir los Reserva_servicios de la clase Reserva_servicios
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class Reserva_servicioService {
	private final Reserva_servicioRepository rsRepository;
	
	public Reserva_servicioService(Reserva_servicioRepository rsRepository) {
		this.rsRepository = rsRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Reserva_servicio
	 * @param Reserva_servicio
	 * @return
	 */
	@Transactional
	public Reserva_servicio create(Reserva_servicio rs) {
		return this.rsRepository.save(rs);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Reserva_servicio
	 * @param Reserva_servicio
	 * @return
	 */
	@Transactional
	public Reserva_servicio update(Reserva_servicio rs) {
		return this.rsRepository.save(rs);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Reserva_servicio
	 * @param Reserva_servicio
	 * @return
	 */
	@Transactional
	public void delete(Reserva_servicio rs) {
		this.rsRepository.delete(rs);
	}
	
	public Reserva_servicio findByReserva_servicio_id_reservas(int id_reservas){
		return this.rsRepository.findByReserva_servicio_id_reservas(id_reservas);
	}
	
	public List<Reserva_servicio> findAll(){
		return this.rsRepository.findAll();
	}
	
}
