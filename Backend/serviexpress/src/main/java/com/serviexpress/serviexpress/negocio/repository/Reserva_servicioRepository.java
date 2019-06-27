/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Reserva_servicio;
import com.serviexpress.serviexpress.modelo.Servicio;

/**
 * @author Arekkusu888
 *
 */
public interface Reserva_servicioRepository extends JpaRepository<Reserva_servicio,Integer>{
	public Reserva_servicio findByReserva_servicio_id_reservas(int id_reservas, int id_servicios);
	public List<Servicio> findServiciosReserva(int id_reservas);
}
