package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviexpress.serviexpress.modelo.Cliente;
/**
 * @author Arekkusu888
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	public Cliente findById_cliente(int id_personas);
}
