package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Persona;
/**
 * @author Arekkusu888
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	public Persona findById_persona(int id_personas);
}
