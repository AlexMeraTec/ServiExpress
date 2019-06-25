package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviexpress.serviexpress.modelo.Persona;
/**
 * @author Arekkusu888
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	public Persona findById_personas(int id_personas);
	@Query(value = "select max(id_personas) from personas", nativeQuery = true)
	public int getLastId();
}
