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
 * Clase que representa el serivio WEB de Reservas
 * @author arekkusu888
 *
 */
@RestController
@RequestMapping("/api/producto") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "producto")
public class ProductoResource {
	private final ProductoService productoService;
	
	public ProductoResource(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto", notes = "Servicio para crear un nuevo producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Producto> createProducto(@RequestBody ProductoVO productoVO){
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
	
	@PutMapping("/{id_productos}")
	@ApiOperation(value = "Actualizar Producto", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<Producto> updateReserva(@PathVariable("id_productos") String id_productos, ProductoVO productoVO){
		Producto producto = this.productoService.findById_productos(id_productos);
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
		return new ResponseEntity<>(this.productoService.update(producto), HttpStatus.OK);
	}
	@PutMapping("/{precio_venta}/{id_productos}")
	@ApiOperation(value = "Actualizar precio_venta", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public void updatePrecio_venta(@PathVariable("precio_venta") int precio_venta,@PathVariable("id_productos") String id_productos){
		Producto producto = this.productoService.findById_productos(id_productos);
		if (producto!=null) {
			producto.setPrecio_venta(precio_venta);
			this.productoService.update(producto);
		}
	}
	@DeleteMapping("/{id_producto}")
	@ApiOperation(value = "Eliminar Producto", notes = "Servicio para eliminar una producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public void removeProducto(@PathVariable("id_productos") String id_productos, ProductoVO productoVO) {
		Producto producto = this.productoService.findById_productos(id_productos);
		if (producto!=null) {
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
			producto.setActivo(false);
			this.productoService.update(producto);
		}
	}

 	@GetMapping("/{id_productos}")
	@ApiOperation(value = "Buscar Producto", notes = "Reserva para buscar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<Producto> findByid_productoss(String id_productos) {
		Producto prod = this.productoService.findById_productos(id_productos);
		return ResponseEntity.ok(prod);
	}
	

	@GetMapping
	@ApiOperation(value = "Listar productos", notes = "Servicio para listar todos los productos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<List<Producto>> findAll() {
		return ResponseEntity.ok(this.productoService.findAll());
	
	}
 
}
