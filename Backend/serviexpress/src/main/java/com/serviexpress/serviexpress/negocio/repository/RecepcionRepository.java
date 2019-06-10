/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Recepcion;

/**
 * @author Arekkusu888
 *
 */
public interface RecepcionRepository extends JpaRepository<Recepcion,Integer>{
	public Recepcion findById_recepcion(int id_servicios);
}
