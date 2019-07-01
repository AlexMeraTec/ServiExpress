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

import com.serviexpress.serviexpress.modelo.Cliente;
import com.serviexpress.serviexpress.modelo.Empleado;
import com.serviexpress.serviexpress.modelo.Persona;
import com.serviexpress.serviexpress.negocio.services.ClienteService;
import com.serviexpress.serviexpress.negocio.services.PersonaService;
import com.serviexpress.serviexpress.negocio.services.ReservaService;
import com.serviexpress.serviexpress.vista.resources.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Clientes
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/cliente") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "cliente")
public class ClienteResource extends Elohim{
	private final  ClienteService clienteService;
	private final  PersonaService personaService;
	private final ReservaService rService;
	public ClienteResource(ClienteService clienteService,PersonaService personaService,ReservaService rService) {
		this.clienteService = clienteService;
		this.personaService = personaService;
		this.rService = rService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear una nueva Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida"),@ApiResponse(code = 208, message = "Cliente con la ID YA EXISTE")})
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO cVO){
		Cliente clientePersona = new Cliente();
		if(clienteService.findById_cliente(cVO.getId_cliente()) != null) {
			return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}else{
			copiarPropiedadesNoNulas(cVO, clientePersona);
			Persona persona = new Persona();
			copiarPropiedadesNoNulas(cVO.getPersonaCliente(), persona);
			persona.setTipo(false);
			persona.setActiva(true);
			clientePersona.setFiable(false);
			clientePersona.setPersonaCliente(persona);
			this.personaService.create(persona);
			clientePersona.setId_cliente(this.personaService.getLastId());
			return new ResponseEntity<>(this.clienteService.create(clientePersona), HttpStatus.CREATED);	
		}
		
	}
	
	@PutMapping("/{id_personas}")
	@ApiOperation(value = "actualizar Cliente", notes = "Servicio para actualizar un Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id_personas") int id_personas, @RequestBody ClienteVO cVO){
		Cliente cliPerso = this.clienteService.findById_cliente(id_personas);
		if (cliPerso==null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}else{
			copiarPropiedadesNoNulas(cVO, cliPerso);
			Persona persona = this.personaService.findById_personas(id_personas);
			copiarPropiedadesNoNulas(cVO.getPersonaCliente(), persona);
			cliPerso.setId_cliente(id_personas);
			persona.setId_personas(id_personas);
			persona.setTipo(true);
			cliPerso.setPersonaCliente(persona);
			this.personaService.update(persona);
			
			
			return new ResponseEntity<>(this.clienteService.update(cliPerso), HttpStatus.OK);
		}
		//return new ResponseEntity<>(this.clienteService.update(cliPerso), HttpStatus.OK);
		
		/*
		 Empleado empleadoPerso = this.empService.findById_empleado(id_personas);
		if (empleadoPerso==null) {
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, empleadoPerso);
			Persona persona = this.personaService.findById_personas(id_personas);
			copiarPropiedadesNoNulas(VO.getPersonaCliente(), persona);
			persona.setTipo(true);
			empleadoPerso.setPersonaEmpleado(persona);
			this.personaService.update(persona);
			return new ResponseEntity<>(this.empService.update(empleadoPerso), HttpStatus.OK);
		}
		 */
	}
	@PutMapping("/fiable/{id_personas}")
	@ApiOperation(value = "actualizar Cliente", notes = "Servicio para actualizar un Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public ResponseEntity<Cliente> esfiable(@PathVariable("id_personas") int id_personas, @RequestBody Boolean fiable){
		Cliente cliPerso = this.clienteService.findById_cliente(id_personas);
		if (cliPerso==null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}else{
			cliPerso.setFiable(fiable);
			return new ResponseEntity<>(this.clienteService.update(cliPerso), HttpStatus.OK);
		}
	}
	@DeleteMapping("/{id_personas}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar una Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ELIMINADa correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public void removeCliente(@PathVariable("id_personas") int id_personas) {
		Cliente cliPerso = this.clienteService.findById_cliente(id_personas);
		if (cliPerso!=null) {
			this.clienteService.delete(cliPerso);
			this.personaService.delete(this.personaService.findById_personas(id_personas));
		}
	}

 	@GetMapping("/{id_personas}")
	@ApiOperation(value = "Buscar Cliente", notes = "servicio para buscar un Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public ResponseEntity<Cliente> findByid_personas(int id_personas) {
 		Cliente cliPerso = this.clienteService.findById_cliente(id_personas);
		return ResponseEntity.ok(cliPerso);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "servicio para listar todos los Clientes")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Clientes NO encontrado")})
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
}
