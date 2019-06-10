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

import com.serviexpress.serviexpress.modelo.Producto_pedido;
import com.serviexpress.serviexpress.negocio.services.Producto_pedidoService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.Producto_pedidoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Producto_pedidos
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/producto_pedido") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "producto_pedido")
public class Producto_pedidoResource extends Elohim{
	private final Producto_pedidoService ppdoService;
	
	public Producto_pedidoResource(Producto_pedidoService ppdoService) {
		this.ppdoService = ppdoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto_pedido", notes = "Servicio para crear un nuevo Producto_pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_pedido CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Producto_pedido> createProducto_pedido(@RequestBody Producto_pedidoVO VO){
		Producto_pedido ppdo = new Producto_pedido();
		copiarPropiedadesNoNulas(VO, ppdo);
		return new ResponseEntity<>(this.ppdoService.create(ppdo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_pedidos}")
	@ApiOperation(value = "actualizar Producto_pedido", notes = "Servicio para actualizar un Producto_pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_pedido ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto_pedido NO encontrado")})
	public ResponseEntity<Producto_pedido> updateProducto_pedido(@PathVariable("id_pedidos") int id_pedidos, Producto_pedidoVO VO){
		Producto_pedido ppdo = this.ppdoService.findByProducto_pedido_id_pedidos(id_pedidos);
		if (ppdo==null) {
			return new ResponseEntity<Producto_pedido>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, ppdo);
		}
		return new ResponseEntity<>(this.ppdoService.update(ppdo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_pedidos}")
	@ApiOperation(value = "Eliminar Producto_pedido", notes = "Servicio para eliminar un Producto_pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_pedido ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Producto_pedido NO encontrado")})
	public void removeProducto_pedido(@PathVariable("id_pedidos") int id_pedidos) {
		Producto_pedido ppdo = this.ppdoService.findByProducto_pedido_id_pedidos(id_pedidos);
		if (ppdo!=null) {
			this.ppdoService.delete(ppdo);
		}
	}

 	@GetMapping("/{id_pedidos}")
	@ApiOperation(value = "Buscar Producto_pedido", notes = "servicio para buscar un Producto_pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_pedido ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Producto_pedido NO encontrado")})
	public ResponseEntity<Producto_pedido> findById_pedidos(int id_pedidos) {
 		Producto_pedido ppdo = this.ppdoService.findByProducto_pedido_id_pedidos(id_pedidos);
		return ResponseEntity.ok(ppdo);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Producto_pedidos", notes = "servicio para listar todos los Producto_pedidos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto_pedidos ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Producto_pedidos NO encontrados")})
	public ResponseEntity<List<Producto_pedido>> findAll() {
		return ResponseEntity.ok(this.ppdoService.findAll());
	}
}
