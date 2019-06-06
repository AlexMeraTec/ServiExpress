package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Empleado;
/**
 * @author Arekkusu888
 *
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	public Empleado findById_personas(int id_personas);
}
