/**
 * 
 */
package com.serviexpress.serviexpress.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serviexpress.serviexpress.modelo.Producto_reserva;

/**
 * @author Arekkusu888
 *
 */
public interface Producto_reservaRepository extends JpaRepository<Producto_reserva,String>{
	public Producto_reserva findByProducto_reserva_id_reservas(String id_productos);
}
