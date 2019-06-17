package com.serviexpress.serviexpress.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviexpress.serviexpress.modelo.Vehiculo;
import com.serviexpress.serviexpress.negocio.repository.VehiculoRepository;

/**
 * Clase para definir los Vehiculos de la clase Vehiculos
 * @author arekkusu888
 *
 */
@Service
//@Transactional(readOnly = true)
public class VehiculoService {
	private final VehiculoRepository veRepository;
	
	public VehiculoService(VehiculoRepository veRepository) {
		this.veRepository = veRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un Vehiculo
	 * @param Vehiculo
	 * @return
	 */
	@Transactional
	public Vehiculo create(Vehiculo vehi) {
		return this.veRepository.save(vehi);
	}
	/**
	 * Metodo para realizar la operacion de actualizar un Vehiculo
	 * @param Vehiculo
	 * @return
	 */
	@Transactional
	public Vehiculo update(Vehiculo vehi) {
		return this.veRepository.save(vehi);
	}
	/**
	 * Metodo para realizar la operacion de eliminar un Vehiculo
	 * @param Vehiculo
	 * @return
	 */
	@Transactional
	public void delete(Vehiculo vehi) {
		this.veRepository.delete(vehi);
	}
	
	public Vehiculo findByPatente(String patente){
		return this.veRepository.findByPatente(patente);
	}
	
	public List<Vehiculo> findAll(){
		return this.veRepository.findAll();
	}
	
}
