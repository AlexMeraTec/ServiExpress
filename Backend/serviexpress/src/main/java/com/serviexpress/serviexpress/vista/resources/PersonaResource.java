package com.serviexpress.serviexpress.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviexpress.serviexpress.modelo.Persona;
import com.serviexpress.serviexpress.negocio.services.PersonaService;
import com.serviexpress.serviexpress.vista.resources.vo.PersonaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de personas
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/persona") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "persona")
public class PersonaResource extends Elohim{
	private final PersonaService personaService;
	
	public PersonaResource(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear persona", notes = "Servicio para crear una nueva persona")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "persona CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Persona> createpersona(@RequestBody PersonaVO personaVO){
		Persona persona = new Persona();
		copiarPropiedadesNoNulas(personaVO, persona);
		return new ResponseEntity<>(this.personaService.create(persona), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_personas}")
	@ApiOperation(value = "actualizar persona", notes = "Servicio para actualizar un persona")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "persona ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "persona NO encontrada")})
	public ResponseEntity<Persona> updatepersona(@PathVariable("id_personas") int id_personas,@RequestBody PersonaVO personaVO){
		Persona persona = this.personaService.findById_personas(id_personas);
		if (persona==null) {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		}else {
			personaVO.setId_personas(id_personas);
			copiarPropiedadesNoNulas(personaVO, persona);
		}
		return new ResponseEntity<>(this.personaService.update(persona), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_personas}")
	@ApiOperation(value = "Eliminar persona", notes = "Servicio para eliminar una persona")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "persona ELIMINADA correctamente"),@ApiResponse(code = 404, message = "persona NO encontrado")})
	public void removepersona(@PathVariable("id_personas") int id_personas) {
		Persona persona = this.personaService.findById_personas(id_personas);
		if (persona!=null) {
			this.personaService.delete(persona);
		}
	}

 	@GetMapping("/{id_personas}")
	@ApiOperation(value = "Buscar persona", notes = "persona para buscar un persona")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "persona ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "persona NO encontrado")})
	public ResponseEntity<PersonaVO> findById_personas(int id_personas) {
 		Persona perso = this.personaService.findById_personas(id_personas);
 		PersonaVO pVO = new PersonaVO();
 		copiarPropiedadesNoNulas(perso, pVO);
		return ResponseEntity.ok(pVO);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar personas", notes = "Metodo para listar todas las personas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "personas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "personas NO encontrado")})
	public ResponseEntity<List<Persona>> findAll() {
		return ResponseEntity.ok(this.personaService.findAll());
	}
	
//	@GetMapping("/LOGINUSER")
//	@ApiOperation(value = "LOGINUSER", notes = "Metodo para LOGINUSER")
//	@ApiResponses(value = {@ApiResponse(code = 201, message = "LOGINUSER ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "LOGINUSER NO encontrado")})
//	public ResponseEntity<Boolean> LOGINUSER(@PathVariable String usuario,@PathVariable String password) {
//		boolean login=false;
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return ResponseEntity.ok(true);
//	}
	
	@GetMapping("/LOGINUSER") 
	@ApiOperation(value = "LOGINUSER", notes = "Metodo para LOGINUSER")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "LOGINUSER ENCONTRADOS correctamente"),@ApiResponse(code = 201, message = "LOGINUSER ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "REVISE SU USUARIO O PASSWORD")})
	public ResponseEntity<PersonaVO> LOGINUSER(String v_username, String v_password) {
		int si = (int) this.personaService.LOGINUSER(v_username, v_password);
		if(si==1){
			Persona perso =this.personaService.personaLogin(v_username, v_password);
			PersonaVO pVO = new PersonaVO();
	 		copiarPropiedadesNoNulas(perso, pVO);
			return ResponseEntity.ok(pVO);
			
		}else {
			return new ResponseEntity<PersonaVO>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/findByRut") 
	@ApiOperation(value = "findByRut", notes = "Metodo para encontrar por rut")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Persona ENCONTRADA correctamente"),@ApiResponse(code = 404, message = "Persona NO encontrada")})
	public ResponseEntity<PersonaVO> findByRut(int rut,char dv) {
		PersonaVO pVO = new PersonaVO();
		Persona perso = this.personaService.findByRut(rut, dv);
		copiarPropiedadesNoNulas(perso, pVO);
		return ResponseEntity.ok(pVO);
	}
}
