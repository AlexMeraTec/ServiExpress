/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Reserva;

/**
 * @author Arekkusu888
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
	public Reserva findById_reservas(int id_servicios);
}
