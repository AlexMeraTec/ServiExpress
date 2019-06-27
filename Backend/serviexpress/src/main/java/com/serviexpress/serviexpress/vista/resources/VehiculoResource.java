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
import com.serviexpress.serviexpress.modelo.Vehiculo;
import com.serviexpress.serviexpress.negocio.services.ClienteService;
import com.serviexpress.serviexpress.negocio.services.VehiculoService;
import com.serviexpress.serviexpress.vista.resources.vo.VehiculoVO;
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
@RequestMapping("/api/vehiculo") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "vehiculo")
public class VehiculoResource extends Elohim{
	private final VehiculoService veService;
	private final ClienteService perService;
	public VehiculoResource(VehiculoService veService,ClienteService perService) {
		this.veService	=	veService;
		this.perService	=	perService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Vehiculo", notes = "Servicio para crear un nuevo vehiculo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<VehiculoVO> createVehiculo(@RequestBody VehiculoVO VO){
		Vehiculo vehiculo = new Vehiculo();
		copiarPropiedadesNoNulas(VO, vehiculo);
		vehiculo.setClienteVehiculo(this.perService.findById_cliente(VO.getId_cliente()));
		this.veService.create(vehiculo);
		return new ResponseEntity<>(VO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{patente}")
	@ApiOperation(value = "Actualizar Vehiculo", notes = "Servicio para actualizar un vehiculo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Vehiculo NO encontrado")})
	public ResponseEntity<Vehiculo> updateReserva(@PathVariable("patente") String patente, @RequestBody VehiculoVO vo){
		Vehiculo vehiculo = this.veService.findByPatente(patente);
		if (vehiculo==null) {
			return new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(vo, vehiculo);
		}
		return new ResponseEntity<>(this.veService.update(vehiculo), HttpStatus.OK);
	}
	@PutMapping("/{precio_venta}/{patente}")
	@ApiOperation(value = "Actualizar precio_venta", notes = "Servicio para actualizar un vehiculo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Vehiculo NO encontrado")})
	public void updatePrecio_venta(@PathVariable("precio_venta") int precio_venta,@PathVariable("patente") String patente){
		Vehiculo vehiculo = this.veService.findByPatente(patente);
		if (vehiculo!=null) {
			this.veService.update(vehiculo);
		}
	}
	@DeleteMapping("/{id_vehiculo}")
	@ApiOperation(value = "Eliminar Vehiculo", notes = "Servicio para eliminar una vehiculo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Vehiculo NO encontrado")})
	public void removeVehiculo(@PathVariable("patente") String patente, VehiculoVO vo) {
		Vehiculo vehiculo = this.veService.findByPatente(patente);
		if (vehiculo!=null) {
			this.veService.update(vehiculo);
		}
	}

 	@GetMapping("/{patente}")
	@ApiOperation(value = "Buscar Vehiculo", notes = "Reserva para buscar un vehiculo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Vehiculo NO encontrado")})
	public ResponseEntity<Vehiculo> findBypatentes(String patente) {
		Vehiculo prod = this.veService.findByPatente(patente);
		return ResponseEntity.ok(prod);
	}
	

	@GetMapping
	@ApiOperation(value = "Listar vehiculos", notes = "Servicio para listar todos los vehiculos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehiculo ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Vehiculo NO encontrado")})
	public ResponseEntity<List<Vehiculo>> findAll() {
		return ResponseEntity.ok(this.veService.findAll());
	
	}
 
}
