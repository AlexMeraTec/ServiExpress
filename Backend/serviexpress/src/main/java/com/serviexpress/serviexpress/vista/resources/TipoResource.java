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

import com.serviexpress.serviexpress.modelo.Tipo;
import com.serviexpress.serviexpress.negocio.services.TipoService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.TipoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Tipos
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/tipo") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "tipo")
public class TipoResource extends Elohim{
	private final TipoService tipoService;
	
	public TipoResource(TipoService tipoService) {
		this.tipoService = tipoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Tipo", notes = "Servicio para crear una nueva Tipo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tipo CREADA correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Tipo> createTipo(@RequestBody TipoVO VO){
		Tipo tipo = new Tipo();
		copiarPropiedadesNoNulas(VO, tipo);
		return new ResponseEntity<>(this.tipoService.create(tipo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_tipos}")
	@ApiOperation(value = "actualizar Tipo", notes = "Servicio para actualizar una Tipo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tipo ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Tipo NO encontrada")})
	public ResponseEntity<Tipo> updateTipo(@PathVariable("id_tipos") int id_tipos, @RequestBody TipoVO VO){
		Tipo tipo = this.tipoService.findById_tipos(id_tipos);
		if (tipo==null) {
			return new ResponseEntity<Tipo>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, tipo);
		}
		return new ResponseEntity<>(this.tipoService.update(tipo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_tipos}")
	@ApiOperation(value = "Eliminar Tipo", notes = "Servicio para eliminar una Tipo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tipo ELIMINADA correctamente"),@ApiResponse(code = 404, message = "Tipo NO encontrada")})
	public void removeTipo(@PathVariable("id_tipos") int id_tipos) {
		Tipo tipo = this.tipoService.findById_tipos(id_tipos);
		if (tipo!=null) {
			this.tipoService.delete(tipo);
		}
	}

 	@GetMapping("/{id_tipos}")
	@ApiOperation(value = "Buscar Tipo", notes = "servicio para buscar una Tipo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tipo ENCONTRADA correctamente"),@ApiResponse(code = 404, message = "Tipo NO encontrada")})
	public ResponseEntity<Tipo> findByid_empleados(int id_tipos) {
 		Tipo tipo = this.tipoService.findById_tipos(id_tipos);
		return ResponseEntity.ok(tipo);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Tipos", notes = "servicio para listar todas las Tipos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tipos ENCONTRADAS correctamente"),@ApiResponse(code = 404, message = "Tipos NO encontrada")})
	public ResponseEntity<List<Tipo>> findAll() {
		return ResponseEntity.ok(this.tipoService.findAll());
	}
}
