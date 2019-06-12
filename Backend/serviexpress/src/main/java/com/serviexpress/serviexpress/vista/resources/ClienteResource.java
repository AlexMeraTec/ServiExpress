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
import com.serviexpress.serviexpress.modelo.Persona;
import com.serviexpress.serviexpress.negocio.services.ClienteService;
import com.serviexpress.serviexpress.negocio.services.PersonaService;
import com.serviexpress.serviexpress.vista.resources.vo.ClienteVO;
import com.serviexpress.serviexpress.vista.resources.vo.PersonaVO;

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
	private final ClienteService ClienteService;
	private final PersonaService personaService;
	
	public ClienteResource(ClienteService ClienteService,PersonaService personaService) {
		this.ClienteService = ClienteService;
		this.personaService=personaService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear una nueva Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO cVO,PersonaVO pVO){
		Cliente clientePersona = new Cliente();
		Persona persona = personaService.findById_personas(pVO.getId_personas());
		//copiarPropiedadesNoNulas(pVO, persona);
		//copiarPropiedadesNoNulas(cVO, clientePersona);
		if(persona!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}else{
			persona = new Persona();
			copiarPropiedadesNoNulas(pVO, persona);
			copiarPropiedadesNoNulas(cVO, clientePersona);
			this.personaService.create(persona);
			return new ResponseEntity<>(this.ClienteService.create(clientePersona), HttpStatus.CREATED);	
		}
		
	}
	
	@PutMapping("/{id_personas}")
	@ApiOperation(value = "actualizar Cliente", notes = "Servicio para actualizar un Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ACTUALIZADA correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrada")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id_personas") int id_personas, ClienteVO personaVO, PersonaVO pVO){
		Cliente perso = this.ClienteService.findById_personas(id_personas);
		if (perso==null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}else{
			
			copiarPropiedadesNoNulas(personaVO, perso);
		}
		return new ResponseEntity<>(this.ClienteService.update(perso), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_personas}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar una Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ELIMINADa correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public void removeCliente(@PathVariable("id_personas") int id_personas) {
		Cliente perso = this.ClienteService.findById_personas(id_personas);
		if (perso!=null) {
			this.ClienteService.delete(perso);
		}
	}

 	@GetMapping("/{id_personas}")
	@ApiOperation(value = "Buscar Cliente", notes = "servicio para buscar un Cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Cliente NO encontrado")})
	public ResponseEntity<Cliente> findByid_personas(int id_personas) {
 		Cliente perso = this.ClienteService.findById_personas(id_personas);
		return ResponseEntity.ok(perso);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "servicio para listar todos los Clientes")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Clientes NO encontrado")})
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.ClienteService.findAll());
	}
}
