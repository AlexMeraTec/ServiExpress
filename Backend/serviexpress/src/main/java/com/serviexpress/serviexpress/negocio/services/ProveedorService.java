package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Proveedor;
import com.serviexpress.serviexpress.negocio.repository.ProveedorRepository;

/**
 * Clase para definir los Proveedors de la clase Proveedors
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class ProveedorService {
	private final ProveedorRepository proveRepository;
	
	public ProveedorService(ProveedorRepository proveRepository) {
		this.proveRepository = proveRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Proveedor
	 * @param Proveedor
	 * @return
	 */
	@Transactional
	public Proveedor create(Proveedor pp) {
		return this.proveRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Proveedor
	 * @param Proveedor
	 * @return
	 */
	@Transactional
	public Proveedor update(Proveedor pp) {
		return this.proveRepository.save(pp);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Proveedor
	 * @param Proveedor
	 * @return
	 */
	@Transactional
	public void delete(Proveedor pp) {
		this.proveRepository.delete(pp);
	}
	
	public Proveedor findById_proveedor(int id_proveedor){
		return this.proveRepository.findById_proveedor(id_proveedor);
	}
	
	public List<Proveedor> findAll(){
		return this.proveRepository.findAll();
	}
	
}
