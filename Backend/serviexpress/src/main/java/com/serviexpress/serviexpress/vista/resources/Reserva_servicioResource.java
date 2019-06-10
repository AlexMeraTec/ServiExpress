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

import com.serviexpress.serviexpress.modelo.Reserva_servicio;
import com.serviexpress.serviexpress.negocio.services.Reserva_servicioService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.Reserva_servicioVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Reserva_servicios
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/reserva_servicio") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "reserva_servicio")
public class Reserva_servicioResource extends Elohim{
	private final Reserva_servicioService resSerService;
	
	public Reserva_servicioResource(Reserva_servicioService resSerService) {
		this.resSerService = resSerService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva_servicio", notes = "Servicio para crear un nuevo Reserva_servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva_servicio CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Reserva_servicio> createReserva_servicio(@RequestBody Reserva_servicioVO VO){
		Reserva_servicio resSer = new Reserva_servicio();
		copiarPropiedadesNoNulas(VO, resSer);
		return new ResponseEntity<>(this.resSerService.create(resSer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_reserva}")
	@ApiOperation(value = "actualizar Reserva_servicio", notes = "Servicio para actualizar un Reserva_servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva_servicio ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Reserva_servicio NO encontrado")})
	public ResponseEntity<Reserva_servicio> updateReserva_servicio(@PathVariable("id_reserva") int id_reserva, Reserva_servicioVO VO){
		Reserva_servicio resSer = this.resSerService.findByReserva_servicio_id_reservas(id_reserva);
		if (resSer==null) {
			return new ResponseEntity<Reserva_servicio>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, resSer);
		}
		return new ResponseEntity<>(this.resSerService.update(resSer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_reserva}")
	@ApiOperation(value = "Eliminar Reserva_servicio", notes = "Servicio para eliminar un Reserva_servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva_servicio ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Reserva_servicio NO encontrado")})
	public void removeReserva_servicio(@PathVariable("id_reserva") int id_reservas) {
		Reserva_servicio resSer = this.resSerService.findByReserva_servicio_id_reservas(id_reservas);
		if (resSer!=null) {
			this.resSerService.delete(resSer);
		}
	}

 	@GetMapping("/{id_reserva}")
	@ApiOperation(value = "Buscar Reserva_servicio", notes = "servicio para buscar un Reserva_servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva_servicio ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Reserva_servicio NO encontrado")})
	public ResponseEntity<Reserva_servicio> findById_reserva_servicio(int id_reserva) {
 		Reserva_servicio resSer = this.resSerService.findByReserva_servicio_id_reservas(id_reserva);
		return ResponseEntity.ok(resSer);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Reserva_servicios", notes = "servicio para listar todos los Reserva_servicios")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva_servicios ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reserva_servicios NO encontrados")})
	public ResponseEntity<List<Reserva_servicio>> findAll() {
		return ResponseEntity.ok(this.resSerService.findAll());
	}
}
