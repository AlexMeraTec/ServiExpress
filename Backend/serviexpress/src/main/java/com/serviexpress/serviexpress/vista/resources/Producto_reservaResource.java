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

import com.serviexpress.serviexpress.modelo.Producto_reserva;
import com.serviexpress.serviexpress.negocio.services.Producto_reservaService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.Producto_reservaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Producto_reservas
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/producto_reserva") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "producto_reserva")
public class Producto_reservaResource extends Elohim{
	private final Producto_reservaService prService;
	
	public Producto_reservaResource(Producto_reservaService prService) {
		this.prService = prService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto_reserva", notes = "Servicio para crear un nuevo Producto_reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_reserva CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Producto_reserva> createProducto_reserva(@RequestBody Producto_reservaVO VO){
		Producto_reserva prorev = new Producto_reserva();
		copiarPropiedadesNoNulas(VO, prorev);
		return new ResponseEntity<>(this.prService.create(prorev), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_productos}")
	@ApiOperation(value = "actualizar Producto_reserva", notes = "Servicio para actualizar un Producto_reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_reserva ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto_reserva NO encontrado")})
	public ResponseEntity<Producto_reserva> updateProducto_reserva(@PathVariable("id_productos") String id_productos, @PathVariable("id_reservas") int id_reservas, Producto_reservaVO VO){
		Producto_reserva prorev = this.prService.findByProducto_reserva_id_reservas(id_productos, id_reservas);
		if (prorev==null) {
			return new ResponseEntity<Producto_reserva>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, prorev);
		}
		return new ResponseEntity<>(this.prService.update(prorev), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_productos}")
	@ApiOperation(value = "Eliminar Producto_reserva", notes = "Servicio para eliminar un Producto_reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_reserva ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Producto_reserva NO encontrado")})
	public void removeProducto_reserva(@PathVariable("id_productos") String id_productos, @PathVariable("id_reservas") int id_reservas) {
		Producto_reserva prorev = this.prService.findByProducto_reserva_id_reservas(id_productos, id_reservas);
		if (prorev!=null) {
			this.prService.delete(prorev);
		}
	}

 	@GetMapping("/{id_productos}")
	@ApiOperation(value = "Buscar Producto_reserva", notes = "servicio para buscar un Producto_reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_reserva ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Producto_reserva NO encontrado")})
	public ResponseEntity<Producto_reserva> findById_pedidos(String id_productos, int id_reservas) {
 		Producto_reserva prorev = this.prService.findByProducto_reserva_id_reservas(id_productos, id_reservas);
		return ResponseEntity.ok(prorev);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Producto_reservas", notes = "servicio para listar todos los Producto_reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Producto_reservas NO encontrados")})
	public ResponseEntity<List<Producto_reserva>> findAll() {
		return ResponseEntity.ok(this.prService.findAll());
	}
}
