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

import com.serviexpress.serviexpress.modelo.Producto;
import com.serviexpress.serviexpress.negocio.services.ProductoService;
import com.serviexpress.serviexpress.vista.resources.vo.ProductoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el serivio WEB de Servicios
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/producto") //el nombre con el cual llamare a esta clase como servicio web
@Api(tags = "producto")
public class ProductoResource {
	private final ProductoService productoService;
	
	public ProductoResource(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto", notes = "Servicio para crear un nuevo Producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Producto> createServicio(@RequestBody ProductoVO productoVO){
		Producto producto = new Producto();
		producto.setId_productos(productoVO.getId_productos());
		producto.setNombre(productoVO.getNombre());
		producto.setFecha_vencimiento(productoVO.getFecha_vencimiento());
		producto.setProveedores_id_proveedor(productoVO.getProveedores_id_proveedor());
		producto.setTipos_id_tipos(productoVO.getTipos_id_tipos());
		producto.setFamilias_id_familias(productoVO.getFamilias_id_familias());
		producto.setPrecio_compra(productoVO.getPrecio_compra());
		producto.setPrecio_venta(productoVO.getPrecio_venta());
		producto.setStock(productoVO.getStock());
		producto.setStock_critico(productoVO.getStock_critico());
		producto.setActivo(productoVO.getActivo());
		
		return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_servicio}")
	@ApiOperation(value = "actualizar Servicio", notes = "Servicio para actualizar un Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public ResponseEntity<Producto> updateServicio(@PathVariable("id_servicio") int id_servicio, ProductoVO productoVO){
		Producto producto = this.productoService.findById_productos(id_servicio);
		if (producto==null) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}else {
			producto.setId_productos(productoVO.getId_productos());
			producto.setNombre(productoVO.getNombre());
			producto.setFecha_vencimiento(productoVO.getFecha_vencimiento());
			producto.setProveedores_id_proveedor(productoVO.getProveedores_id_proveedor());
			producto.setTipos_id_tipos(productoVO.getTipos_id_tipos());
			producto.setFamilias_id_familias(productoVO.getFamilias_id_familias());
			producto.setPrecio_compra(productoVO.getPrecio_compra());
			producto.setPrecio_venta(productoVO.getPrecio_venta());
			producto.setStock(productoVO.getStock());
			producto.setStock_critico(productoVO.getStock_critico());
			producto.setActivo(productoVO.getActivo());
		}
		return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id_servicio}")
	@ApiOperation(value = "Eliminar Servicio", notes = "Servicio para eliminar un nuevo Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public void removeServicio(@PathVariable("id_servicio") int id_servicio) {
		Producto servicio = this.productoService.findById_productos(id_servicio);
		if (servicio!=null) {
			this.productoService.delete(servicio);
		}
	}

 	@GetMapping("/{id_servicio}")
	@ApiOperation(value = "Buscar Servicio", notes = "Servicio para buscar un Servicio")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicio ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Servicio NO encontrado")})
	public ResponseEntity<Producto> findById_servicios(int id_servicios) {
 		Producto serv = this.productoService.findById_productos(id_servicios);
		return ResponseEntity.ok(serv);
		
	}
 
	@GetMapping
	@ApiOperation(value = "Listar Servicios", notes = "Servicio para listar todos los Servicios")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Servicios ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Servicios NO encontrado")})
	public ResponseEntity<List<Producto>> findAll() {
		return ResponseEntity.ok(this.productoService.findAll());
	}
}
