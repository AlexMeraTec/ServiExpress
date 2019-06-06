package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Tipo;

/**
 * Interface para definir las operaciones de bd relacionadas con servicios
 * @author arekkusu888
 *
 */
public interface TipoRepository extends JpaRepository<Tipo, Integer>{
	//public List<Servicio> findByNombreServ(String nombreServ);
	public Tipo findById_tipos(int id_tipos);
	
}
