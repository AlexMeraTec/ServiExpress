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

import com.serviexpress.serviexpress.modelo.Reserva;
import com.serviexpress.serviexpress.negocio.services.ReservaService;
import com.serviexpress.serviexpress.vista.resources.vo.ReservaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Reservas
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/reserva") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "reserva")
public class ReservaResource {
	private final ReservaService reservaService;
	
	public ReservaResource(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear una nueva Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaVO reservaVO){
		Reserva reserva = new Reserva();
		reserva.setId_reservas(reservaVO.getId_reservas());
		reserva.setEmpleados_id_personas(reservaVO.getEmpleados_id_personas());
		reserva.setFecha(reservaVO.getFecha());
		reserva.setObservaciones(reservaVO.getObservaciones());
		reserva.setSe_atendio(reservaVO.getSe_atendio());
		reserva.setClientes_id_personas(reservaVO.getClientes_id_personas());
		return new ResponseEntity<>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_reserva}")
	@ApiOperation(value = "actualizar Reserva", notes = "Servicio para actualizar un Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public ResponseEntity<Reserva> updateReserva(@PathVariable("id_reserva") int id_reserva, ReservaVO reservaVO){
		Reserva reserva = this.reservaService.findById_reservas(id_reserva);
		if (reserva==null) {
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
		}else {
			reserva.setId_reservas(reservaVO.getId_reservas());
			reserva.setEmpleados_id_personas(reservaVO.getEmpleados_id_personas());
			reserva.setFecha(reservaVO.getFecha());
			reserva.setObservaciones(reservaVO.getObservaciones());
			reserva.setSe_atendio(reservaVO.getSe_atendio());
			reserva.setClientes_id_personas(reservaVO.getClientes_id_personas());
			
		}
		return new ResponseEntity<>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id_Reserva}")
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar una Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ELIMINADa correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public void removeReserva(@PathVariable("id_Reserva") int id_Reserva) {
		Reserva Reserva = this.reservaService.findById_reservas(id_Reserva);
		if (Reserva!=null) {
			this.reservaService.delete(Reserva);
		}
	}

 	@GetMapping("/{id_Reserva}")
	@ApiOperation(value = "Buscar Reserva", notes = "Reserva para buscar un Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public ResponseEntity<Reserva> findById_Reservas(int id_Reservas) {
		Reserva resv = this.reservaService.findById_reservas(id_Reservas);
		return ResponseEntity.ok(resv);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Reservas", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<Reserva>> findAll() {
		return ResponseEntity.ok(this.reservaService.findAll());
	}
}
