/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviexpress.serviexpress.modelo.Producto;

/**
 * Interface para definir las operaciones de bd relacionadas con servicios
 * @author arekkusu888
 *
 */
public interface ProductoRepository extends JpaRepository<Producto, String>{
	//public List<Servicio> findByNombreServ(String nombreServ);
	public Producto findById_productos(String id_productos);
	
}
