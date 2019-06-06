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

import com.serviexpress.serviexpress.modelo.Empleado;
import com.serviexpress.serviexpress.negocio.services.EmpleadoService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.EmpleadoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Empleados
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/empleado") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "empleado")
public class EmpleadoResource extends Elohim{
	private final EmpleadoService empService;
	
	public EmpleadoResource(EmpleadoService EmpleadoService) {
		this.empService = EmpleadoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Empleado", notes = "Servicio para crear un nuevo Empleado")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Empleado CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Empleado> createEmpleado(@RequestBody EmpleadoVO VO){
		Empleado perso = new Empleado();
		copiarPropiedadesNoNulas(VO, perso);
		return new ResponseEntity<>(this.empService.create(perso), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_personas}")
	@ApiOperation(value = "actualizar Empleado", notes = "Servicio para actualizar un Empleado")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Empleado ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Empleado NO encontrada")})
	public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id_personas") int id_personas, EmpleadoVO VO){
		Empleado perso = this.empService.findById_personas(id_personas);
		if (perso==null) {
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, perso);
		}
		return new ResponseEntity<>(this.empService.update(perso), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_personas}")
	@ApiOperation(value = "Eliminar Empleado", notes = "Servicio para eliminar un Empleado")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Empleado ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Empleado NO encontrado")})
	public void removeEmpleado(@PathVariable("id_personas") int id_personas) {
		Empleado perso = this.empService.findById_personas(id_personas);
		if (perso!=null) {
			this.empService.delete(perso);
		}
	}

 	@GetMapping("/{id_personas}")
	@ApiOperation(value = "Buscar Empleado", notes = "servicio para buscar un Empleado")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Empleado ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Empleado NO encontrado")})
	public ResponseEntity<Empleado> findByid_empleados(int id_personas) {
 		Empleado perso = this.empService.findById_personas(id_personas);
		return ResponseEntity.ok(perso);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Empleados", notes = "servicio para listar todos los Empleados")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Empleados ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Empleados NO encontrado")})
	public ResponseEntity<List<Empleado>> findAll() {
		return ResponseEntity.ok(this.empService	.findAll());
	}
}
