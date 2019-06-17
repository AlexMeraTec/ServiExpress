package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Vehiculo;

/**
 * @author arekkusu888
 *
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo,String> {
	public Vehiculo findByPatente(String patente);
}
