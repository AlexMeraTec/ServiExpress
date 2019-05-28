/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Servicio;

/**
 * Interface para definir las operaciones de bd relacionadas con servicios
 * @author arekkusu888
 *
 */
public interface ServicioRepository extends JpaRepository<Servicio, String>{
	//public List<Servicio> findByNombreServ(String nombreServ);
	public Servicio findById_servicios(int id_servicios);
	
}
