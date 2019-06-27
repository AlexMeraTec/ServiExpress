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
import com.serviexpress.serviexpress.negocio.services.FamiliaService;
import com.serviexpress.serviexpress.negocio.services.ProductoService;
import com.serviexpress.serviexpress.negocio.services.ProveedorService;
import com.serviexpress.serviexpress.negocio.services.TipoService;
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
public class ProductoResource extends Elohim{
	private final ProductoService productoService;
	private final FamiliaService fService;
	private final TipoService tService;
	private final ProveedorService pService;
	public ProductoResource(ProductoService productoService,FamiliaService fService,TipoService tService,ProveedorService pService) {
		this.productoService = productoService;
		this.fService  = fService;
		this.tService = tService;
		this.pService = pService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto", notes = "Servicio para crear un nuevo producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<Producto> createProducto(@RequestBody ProductoVO ptoVO){
		Producto pto = new Producto();
		copiarPropiedadesNoNulas(ptoVO, pto);
		pto.setId_familias(this.fService.findById_familias(ptoVO.getId_familias()));
		pto.setId_tipos(this.tService.findById_tipos(ptoVO.getId_tipos()));
		pto.setId_proveedor(this.pService.findById_proveedor(ptoVO.getId_proveedor()));
		
		return new ResponseEntity<>(this.productoService.create(pto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_productos}")
	@ApiOperation(value = "Actualizar Producto", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<Producto> updateReserva(@PathVariable("id_productos") String id_productos, @RequestBody ProductoVO ptoVO){
		Producto pto = this.productoService.findById_productos(id_productos);
		if (pto==null) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(ptoVO, pto);
			pto.setId_familias(this.fService.findById_familias(ptoVO.getId_familias()));
			pto.setId_tipos(this.tService.findById_tipos(ptoVO.getId_tipos()));
			pto.setId_proveedor(this.pService.findById_proveedor(ptoVO.getId_proveedor()));
		}
		return new ResponseEntity<>(this.productoService.update(pto), HttpStatus.OK);
	}
	@PutMapping("/{precio_venta}/{id_productos}")
	@ApiOperation(value = "Actualizar precio_venta", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public void updatePrecio_venta(@PathVariable("precio_venta") int precio_venta,@PathVariable("id_productos") String id_productos){
		Producto pto = this.productoService.findById_productos(id_productos);
		if (pto!=null && precio_venta!= pto.getPrecio_venta()) {
			pto.setPrecio_venta(precio_venta);
			this.productoService.update(pto);
		}
	}
	@DeleteMapping("/{id_producto}")
	@ApiOperation(value = "Eliminar Producto", notes = "Servicio para eliminar una producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ELIMINADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public void removeProducto(@PathVariable("id_productos") String id_productos, ProductoVO productoVO) {
		Producto pto = this.productoService.findById_productos(id_productos);
		if (pto!=null) {
			pto.setActivo(false);
			this.productoService.update(pto);
		}
	}

 	@GetMapping("/{id_productos}")
	@ApiOperation(value = "Buscar Producto", notes = "Reserva para buscar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<Producto> findByid_productoss(String id_productos) {
		Producto pto = this.productoService.findById_productos(id_productos);
		return ResponseEntity.ok(pto);
	}
	

	@GetMapping
	@ApiOperation(value = "Listar productos", notes = "Servicio para listar todos los productos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<List<Producto>> findAll() {
		return ResponseEntity.ok(this.productoService.findAll());
	
	}
 
}
