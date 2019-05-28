/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Reserva;
import com.serviexpress.serviexpress.modelo.Servicio;

/**
 * @author Arekkusu888
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva,String>{
	public Servicio findById_reservas(int id_servicios);
}
