/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Reserva;
import com.serviexpress.serviexpress.negocio.repository.ReservaRepository;

/**
 * Clase para definir los servicios de la clase servicios
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class ReservaService {
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un servicio
	 * @param servicio
	 * @return
	 */
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	public Reserva findById_reservas(int id_reservas){
		return this.findById_reservas(id_reservas);
	}
	
	public List<Reserva> findAll(){
		return this.reservaRepository.findAll();
	}
	
}
