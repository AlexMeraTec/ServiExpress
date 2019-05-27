/**
 * 
 */
package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Producto;
import com.serviexpress.serviexpress.negocio.repository.ProductoRepository;

/**
 * Clase para definir los productos de la clase productos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class ProductoService {
	private final ProductoRepository productoRepository;
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un producto
	 * @param ProductoVO
	 * @return
	 */
	@Transactional
	public Producto create(Producto producto) {
		return this.productoRepository.save(producto);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un producto
	 * @param producto
	 * @return
	 */
	@Transactional
	public Producto update(Producto producto) {
		return this.productoRepository.save(producto);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un producto
	 * @param producto
	 * @return
	 */
	@Transactional
	public void delete(Producto producto) {
		this.productoRepository.delete(producto);
	}
	
	public Producto findById_productos(int id_productos){
		return this.findById_productos(id_productos);
	}
	
	public List<Producto> findAll(){
		return this.productoRepository.findAll();
	}
	
}
