package com.serviexpress.serviexpress.vista.resources;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	DecimalFormat formato3 = new DecimalFormat("000");
	String DATE_FORMAT = "yyyyMMdd";
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    
    
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
	public ResponseEntity<ProductoVO> createProducto(@RequestBody ProductoVO ptoVO){
		Producto pto = new Producto();
		copiarPropiedadesNoNulas(ptoVO, pto);
		Date date = ptoVO.getFecha_vencimiento();
        String idFinal = formato3.format(ptoVO.getId_proveedor())+formato3.format(ptoVO.getId_familias())+sdf.format(date)+formato3.format(ptoVO.getId_tipos());
        pto.setId_productos(idFinal);
        pto.setId_familias(this.fService.findById_familias(ptoVO.getId_familias()));
		pto.setId_tipos(this.tService.findById_tipos(ptoVO.getId_tipos()));
		pto.setId_proveedor(this.pService.findById_proveedor(ptoVO.getId_proveedor()));
		this.productoService.create(pto);
		return new ResponseEntity<>(ptoVO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_productos}")
	@ApiOperation(value = "Actualizar Producto", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<ProductoVO> updateReserva(@PathVariable("id_productos") String id_productos, @RequestBody ProductoVO ptoVO){
		Producto pto = this.productoService.findById_productos(id_productos);
		if (pto==null) {
			return new ResponseEntity<ProductoVO>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(ptoVO, pto);
			pto.setId_familias(this.fService.findById_familias(ptoVO.getId_familias()));
			pto.setId_tipos(this.tService.findById_tipos(ptoVO.getId_tipos()));
			pto.setId_proveedor(this.pService.findById_proveedor(ptoVO.getId_proveedor()));
		}
		this.productoService.update(pto);
		return new ResponseEntity<>(ptoVO, HttpStatus.OK);
	}
	@PutMapping("/{id_productos}/{precio_venta}")
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
	public ResponseEntity<ProductoVO> findByid_productoss(String id_productos) {
		Producto pto = this.productoService.findById_productos(id_productos);
		if (pto!=null) {
			ProductoVO ptVO = new ProductoVO();
			copiarPropiedadesNoNulas(pto, ptVO);
			ptVO.setId_proveedor(pto.getId_proveedor().getId_proveedor());
			ptVO.setId_familias(pto.getId_familias().getId_familias());
			ptVO.setId_tipos(pto.getId_tipos().getId_tipos());
			ptVO.setNombreProveedor(pto.getId_proveedor().getNombre());
			ptVO.setNombreFamilia(pto.getId_familias().getNombre());
			ptVO.setNombreTipo(pto.getId_tipos().getNombre());
			return new ResponseEntity<>(ptVO, HttpStatus.OK);
		}else {
			return new ResponseEntity<ProductoVO>(HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping
	@ApiOperation(value = "Listar productos", notes = "Servicio para listar todos los productos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Producto ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Producto NO encontrado")})
	public ResponseEntity<List<ProductoVO>> findAll() {
		List<Producto> pts = this.productoService.findAll();
		List<ProductoVO>ptsVO = new ArrayList<ProductoVO>();
		for (Producto pto : pts) {
			ProductoVO ptVO = new ProductoVO();
			copiarPropiedadesNoNulas(pto, ptVO);
			ptVO.setId_proveedor(pto.getId_proveedor().getId_proveedor());
			ptVO.setId_familias(pto.getId_familias().getId_familias());
			ptVO.setId_tipos(pto.getId_tipos().getId_tipos());
			ptVO.setNombreProveedor(pto.getId_proveedor().getNombre());
			ptVO.setNombreFamilia(pto.getId_familias().getNombre());
			ptVO.setNombreTipo(pto.getId_tipos().getNombre());
			ptsVO.add(ptVO);
		}
		return ResponseEntity.ok(ptsVO);
	
	}
 
}
