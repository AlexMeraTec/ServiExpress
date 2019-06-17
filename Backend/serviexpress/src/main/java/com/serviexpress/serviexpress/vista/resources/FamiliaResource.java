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

import com.serviexpress.serviexpress.modelo.Familia;
import com.serviexpress.serviexpress.negocio.services.FamiliaService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.FamiliaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Familias
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/familia") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "familia")
public class FamiliaResource extends Elohim{
	private final FamiliaService famService;
	
	public FamiliaResource(FamiliaService FamiliaService) {
		this.famService = FamiliaService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Familia", notes = "Servicio para crear una nueva Familia")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Familia CREADA correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Familia> createFamilia(@RequestBody FamiliaVO VO){
		Familia fami = new Familia();
		copiarPropiedadesNoNulas(VO, fami);
		return new ResponseEntity<>(this.famService.create(fami), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_familias}")
	@ApiOperation(value = "actualizar Familia", notes = "Servicio para actualizar una Familia")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Familia ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Familia NO encontrada")})
	public ResponseEntity<Familia> updateFamilia(@PathVariable("id_familias") int id_familias, FamiliaVO VO){
		Familia fami = this.famService.findById_familias(id_familias);
		if (fami==null) {
			return new ResponseEntity<Familia>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, fami);
		}
		return new ResponseEntity<>(this.famService.update(fami), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_familias}")
	@ApiOperation(value = "Eliminar Familia", notes = "Servicio para eliminar una Familia")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Familia ELIMINADA correctamente"),@ApiResponse(code = 404, message = "Familia NO encontrada")})
	public void removeFamilia(@PathVariable("id_familias") int id_familias) {
		Familia fami = this.famService.findById_familias(id_familias);
		if (fami!=null) {
			this.famService.delete(fami);
		}
	}

 	@GetMapping("/{id_familias}")
	@ApiOperation(value = "Buscar Familia", notes = "servicio para buscar una Familia")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Familia ENCONTRADA correctamente"),@ApiResponse(code = 404, message = "Familia NO encontrada")})
	public ResponseEntity<Familia> findByid_empleados(int id_familias) {
 		Familia fami = this.famService.findById_familias(id_familias);
		return ResponseEntity.ok(fami);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Familias", notes = "servicio para listar todas las Familias")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Familias ENCONTRADAS correctamente"),@ApiResponse(code = 404, message = "Familias NO encontrada")})
	public ResponseEntity<List<Familia>> findAll() {
		return ResponseEntity.ok(this.famService.findAll());
	}
}
