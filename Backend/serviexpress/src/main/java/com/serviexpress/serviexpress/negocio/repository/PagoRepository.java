package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Pago;
/**
 * @author Arekkusu888
 *
 */
public interface PagoRepository extends JpaRepository<Pago, Integer>{
	public Pago findById_pago(int id_personas);
}
