/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviexpress.serviexpress.modelo.Reserva;

/**
 * @author Arekkusu888
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
	public Reserva findById_reservas(int id_servicios);
	public List<Reserva> findReservasByCliente(int id_cliente);
	public List<Reserva> findReservasByEmpleado(int id_empleado);
	@Query(value = "select max(id_reservas) from reservas", nativeQuery = true)
	public int getLastId();
}
