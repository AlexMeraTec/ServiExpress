package com.serviexpress.serviexpress.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviexpress.serviexpress.modelo.Pago;
import com.serviexpress.serviexpress.negocio.services.PagoService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.PagoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Pagos
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/pago") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "pago")
public class PagoResource extends Elohim{
	private final PagoService pagoService;
	
	public PagoResource(PagoService pagoService) {
		this.pagoService = pagoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Pago", notes = "Servicio para crear una nueva Pago")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pago CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Pago> createPago(@RequestBody PagoVO VO){
		Pago pgo = new Pago();
		copiarPropiedadesNoNulas(VO, pgo);
		return new ResponseEntity<>(this.pagoService.create(pgo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_pago}")
	@ApiOperation(value = "actualizar Pago", notes = "Servicio para actualizar una Pago")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pago ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Pago NO encontrado")})
	public ResponseEntity<Pago> updatePago(@PathVariable("id_pago") int id_pago, PagoVO VO){
		Pago pgo = this.pagoService.findById_pago(id_pago);
		if (pgo==null) {
			return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, pgo);
		}
		return new ResponseEntity<>(this.pagoService.update(pgo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_pago}")
	@ApiOperation(value = "Eliminar Pago", notes = "Servicio para eliminar un Pago")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pago ELIMINADA correctamente"),@ApiResponse(code = 404, message = "Pago NO encontrado")})
	public void removePago(@PathVariable("id_pago") int id_pago) {
		Pago pgo = this.pagoService.findById_pago(id_pago);
		if (pgo!=null) {
			this.pagoService.delete(pgo);
		}
	}

 	@GetMapping("/{id_pago}")
	@ApiOperation(value = "Buscar Pago", notes = "servicio para buscar un Pago")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pago ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Pago NO encontrado")})
	public ResponseEntity<Pago> findById_pago(int id_pago) {
 		Pago pgo = this.pagoService.findById_pago(id_pago);
		return ResponseEntity.ok(pgo);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Pagos", notes = "servicio para listar todos los Pagos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pagos ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Pagos NO encontrados")})
	public ResponseEntity<List<Pago>> findAll() {
		return ResponseEntity.ok(this.pagoService.findAll());
	}
}
