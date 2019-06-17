/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Proveedor;

/**
 * @author Arekkusu888
 *
 */
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{
	public Proveedor findById_proveedor(int id_servicios);
}
