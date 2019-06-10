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

import com.serviexpress.serviexpress.modelo.Recepcion;
import com.serviexpress.serviexpress.negocio.services.RecepcionService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.RecepcionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Recepcions
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/recepcion") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "recepcion")
public class RecepcionResource extends Elohim{
	private final RecepcionService recService;
	
	public RecepcionResource(RecepcionService recService) {
		this.recService = recService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Recepcion", notes = "Servicio para crear una nueva Recepcion")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recepcion CREADA correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Recepcion> createRecepcion(@RequestBody RecepcionVO VO){
		Recepcion resep = new Recepcion();
		copiarPropiedadesNoNulas(VO, resep);
		return new ResponseEntity<>(this.recService.create(resep), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_recepcion}")
	@ApiOperation(value = "actualizar Recepcion", notes = "Servicio para actualizar una Recepcion")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recepcion ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Recepcion NO encontrado")})
	public ResponseEntity<Recepcion> updateRecepcion(@PathVariable("id_recepcion") int id_recepcion, RecepcionVO VO){
		Recepcion resep = this.recService.findById_recepcion(id_recepcion);
		if (resep==null) {
			return new ResponseEntity<Recepcion>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, resep);
		}
		return new ResponseEntity<>(this.recService.update(resep), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_recepcion}")
	@ApiOperation(value = "Eliminar Recepcion", notes = "Servicio para eliminar una Recepcion")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recepcion ELIMINADA correctamente"),@ApiResponse(code = 404, message = "Recepcion NO encontrado")})
	public void removeRecepcion(@PathVariable("id_recepcion") int id_recepcion) {
		Recepcion resep = this.recService.findById_recepcion(id_recepcion);
		if (resep!=null) {
			this.recService.delete(resep);
		}
	}

 	@GetMapping("/{id_recepcion}")
	@ApiOperation(value = "Buscar Recepcion", notes = "servicio para buscar una Recepcion")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recepcion ENCONTRADA correctamente"),@ApiResponse(code = 404, message = "Recepcion NO encontrada")})
	public ResponseEntity<Recepcion> findById_recepcion(int id_recepcion) {
 		Recepcion resep = this.recService.findById_recepcion(id_recepcion);
		return ResponseEntity.ok(resep);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Recepcions", notes = "servicio para listar todos las Recepciones")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recepcions ENCONTRADAS correctamente"),@ApiResponse(code = 404, message = "Recepciones NO encontradas")})
	public ResponseEntity<List<Recepcion>> findAll() {
		return ResponseEntity.ok(this.recService.findAll());
	}
}
