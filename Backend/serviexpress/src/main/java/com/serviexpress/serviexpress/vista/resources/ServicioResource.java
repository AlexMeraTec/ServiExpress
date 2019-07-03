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

import com.serviexpress.serviexpress.modelo.Servicio;
import com.serviexpress.serviexpress.negocio.services.ServicioService;
import com.serviexpress.serviexpress.vista.resources.vo.ServicioVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Servicios
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/servicio") //el nombre con el cual llamare a esta clase como servicio web
@Api(tags = "servicio")
public class ServicioResource extends Elohim {
	private final ServicioService servicioService;
	
	public ServicioResource(ServicioService servicioService) {
		this.servicioService = servicioService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Servicio", notes = "Servicio para crear un nuevo Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Servicio> createServicio(@RequestBody ServicioVO servicioVO){
		Servicio servicio = new Servicio();
		/*
		servicio.setId_servicios(servicioVO.getId_servicios());
		servicio.setNombre(servicioVO.getNombre());
		servicio.setActivo(servicioVO.getActivo());
		*/
		copiarPropiedadesNoNulas(servicioVO, servicio);
		return new ResponseEntity<>(this.servicioService.create(servicio), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_servicio}")
	@ApiOperation(value = "actualizar Servicio", notes = "Servicio para actualizar un Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public ResponseEntity<Servicio> updateServicio(@PathVariable("id_servicio") int id_servicio, @RequestBody ServicioVO servicioVO){
		Servicio servicio = this.servicioService.findById_servicios(id_servicio);
		if (servicio==null) {
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
		}else {
			/*
			servicio.setId_servicios(servicioVO.getId_servicios());
			servicio.setNombre(servicioVO.getNombre());
			servicio.setActivo(servicioVO.getActivo());
			*/
			copiarPropiedadesNoNulas(servicioVO, servicio);
		}
		return new ResponseEntity<>(this.servicioService.update(servicio), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_servicio}")
	@ApiOperation(value = "Eliminar Servicio", notes = "Servicio para eliminar un nuevo Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public void removeServicio(@PathVariable("id_servicio") int id_servicio) {
		Servicio servicio = this.servicioService.findById_servicios(id_servicio);
		if (servicio!=null) {
			servicio.setActivo(false);
			this.servicioService.update(servicio);
		}
	}

 	@GetMapping("/{id_servicio}")
	@ApiOperation(value = "Buscar Servicio", notes = "Servicio para buscar un Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public ResponseEntity<Servicio> findById_servicios(int id_servicios) {
		Servicio serv = this.servicioService.findById_servicios(id_servicios);
		return ResponseEntity.ok(serv);
		
	}
 	
	@GetMapping
	@ApiOperation(value = "Listar Servicios", notes = "Servicio para listar todos los Servicios")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicios ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Servicios NO encontrado")})
	public ResponseEntity<List<Servicio>> findAll() {
		return ResponseEntity.ok(this.servicioService.findAll());
	}
	
	@GetMapping("/activos")
	@ApiOperation(value = "Listar ServiciosActivos", notes = "Servicio para listar todos los Servicios")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicios activos ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Servicios NO encontrado")})
	public ResponseEntity<List<Servicio>> findActivos() {
		return ResponseEntity.ok(this.servicioService.findActivos());
	}
	
	@GetMapping("/inactivos")
	@ApiOperation(value = "Listar ServiciosInActivos", notes = "Servicio para listar todos los Servicios")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicios inactivos ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Servicios NO encontrado")})
	public ResponseEntity<List<Servicio>> findInactivos() {
		return ResponseEntity.ok(this.servicioService.findInactivos());
	}
}
