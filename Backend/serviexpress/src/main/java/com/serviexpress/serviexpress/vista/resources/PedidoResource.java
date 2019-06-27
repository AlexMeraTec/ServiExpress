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

import com.serviexpress.serviexpress.modelo.Pedido;
import com.serviexpress.serviexpress.negocio.services.PedidoService;
//vo es por Virtual Object
import com.serviexpress.serviexpress.vista.resources.vo.PedidoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Pedidos
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/pedido") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "pedido")
public class PedidoResource extends Elohim{
	private final PedidoService pdoService;
	
	public PedidoResource(PedidoService pdoService) {
		this.pdoService = pdoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Pedido", notes = "Servicio para crear un nuevo Pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pedido CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Pedido> createPedido(@RequestBody PedidoVO VO){
		Pedido pdo = new Pedido();
		copiarPropiedadesNoNulas(VO, pdo);
		return new ResponseEntity<>(this.pdoService.create(pdo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_pedidos}")
	@ApiOperation(value = "actualizar Pedido", notes = "Servicio para actualizar un Pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pedido ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Pedido NO encontrado")})
	public ResponseEntity<Pedido> updatePedido(@PathVariable("id_pedidos") int id_pedidos, @RequestBody PedidoVO VO){
		Pedido pdo = this.pdoService.findById_pedidos(id_pedidos);
		if (pdo==null) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(VO, pdo);
		}
		return new ResponseEntity<>(this.pdoService.update(pdo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_pedidos}")
	@ApiOperation(value = "Eliminar Pedido", notes = "Servicio para eliminar un Pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pedido ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Pedido NO encontrado")})
	public void removePedido(@PathVariable("id_pedidos") int id_pedidos) {
		Pedido pdo = this.pdoService.findById_pedidos(id_pedidos);
		if (pdo!=null) {
			this.pdoService.delete(pdo);
		}
	}

 	@GetMapping("/{id_pedidos}")
	@ApiOperation(value = "Buscar Pedido", notes = "servicio para buscar un Pedido")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pedido ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Pedido NO encontrado")})
	public ResponseEntity<Pedido> findById_pedidos(int id_pedidos) {
 		Pedido pdo = this.pdoService.findById_pedidos(id_pedidos);
		return ResponseEntity.ok(pdo);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Pedidos", notes = "servicio para listar todos los Pedidos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Pedidos ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Pedidos NO encontrados")})
	public ResponseEntity<List<Pedido>> findAll() {
		return ResponseEntity.ok(this.pdoService.findAll());
	}
}
