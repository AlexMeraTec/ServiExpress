/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Reserva_servicio;

/**
 * @author Arekkusu888
 *
 */
public interface Reserva_servicioRepository extends JpaRepository<Reserva_servicio,Integer>{
	public Reserva_servicio findByReserva_servicio_id_reservas(int id_servicios);
}
