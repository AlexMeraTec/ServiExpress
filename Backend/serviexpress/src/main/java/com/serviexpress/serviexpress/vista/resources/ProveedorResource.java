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

import com.serviexpress.serviexpress.modelo.Proveedor;
import com.serviexpress.serviexpress.negocio.services.ProveedorService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.ProveedorVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Proveedors
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/proveedor") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "proveedor")
public class ProveedorResource extends Elohim{
	private final ProveedorService pveService;
	
	public ProveedorResource(ProveedorService pveService) {
		this.pveService = pveService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Proveedor", notes = "Servicio para crear un nuevo Proveedor")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Proveedor CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Proveedor> createProveedor(@RequestBody ProveedorVO VO){
		Proveedor prvee = new Proveedor();
		copiarPropiedadesNoNulas(VO, prvee);
		return new ResponseEntity<>(this.pveService.create(prvee), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_proveedor}")
	@ApiOperation(value = "actualizar Proveedor", notes = "Servicio para actualizar un Proveedor")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Proveedor ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Proveedor NO encontrado")})
	public ResponseEntity<Proveedor> updateProveedor(@PathVariable("id_proveedor") int id_proveedor, @RequestBody ProveedorVO VO){
		Proveedor prvee = this.pveService.findById_proveedor(id_proveedor);
		if (prvee==null) {
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}else {
			VO.setId_proveedor(id_proveedor);
			copiarPropiedadesNoNulas(VO, prvee);
		}
		return new ResponseEntity<>(this.pveService.update(prvee), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_proveedor}")
	@ApiOperation(value = "Eliminar Proveedor", notes = "Servicio para eliminar un Proveedor")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Proveedor ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Proveedor NO encontrado")})
	public void removeProveedor(@PathVariable("id_proveedor") int id_proveedor) {
		Proveedor prvee = this.pveService.findById_proveedor(id_proveedor);
		if (prvee!=null) {
			this.pveService.delete(prvee);
		}
	}

 	@GetMapping("/{id_proveedor}")
	@ApiOperation(value = "Buscar Proveedor", notes = "servicio para buscar un Proveedor")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Proveedor ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Proveedor NO encontrado")})
	public ResponseEntity<Proveedor> findById_proveedor(int id_proveedor) {
 		Proveedor prvee = this.pveService.findById_proveedor(id_proveedor);
		return ResponseEntity.ok(prvee);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Proveedors", notes = "servicio para listar todos los Proveedors")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Proveedors ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Proveedors NO encontrados")})
	public ResponseEntity<List<Proveedor>> findAll() {
		return ResponseEntity.ok(this.pveService.findAll());
	}
}
