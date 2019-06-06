package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Familia;

/**
 * Interface para definir las operaciones de bd relacionadas con servicios
 * @author arekkusu888
 *
 */
public interface FamiliaRepository extends JpaRepository<Familia, Integer>{
	//public List<Servicio> findByNombreServ(String nombreServ);
	public Familia findById_familias(int Id_familias);
	
}
