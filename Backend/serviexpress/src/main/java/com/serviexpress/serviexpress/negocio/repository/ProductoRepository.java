/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviexpress.serviexpress.modelo.Producto;

/**
 * @author Arekkusu888
 *
 */
public interface ProductoRepository extends JpaRepository<Producto,String>{
	public Producto findById_productos(String id_productos);
}
