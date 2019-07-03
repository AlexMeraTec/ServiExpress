package com.serviexpress.serviexpress.vista.resources;

import java.util.ArrayList;
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
import com.serviexpress.serviexpress.modelo.Producto_reserva;
import com.serviexpress.serviexpress.modelo.Reserva;
import com.serviexpress.serviexpress.modelo.Reserva_servicio;
import com.serviexpress.serviexpress.modelo.Servicio;
import com.serviexpress.serviexpress.negocio.services.ClienteService;
import com.serviexpress.serviexpress.negocio.services.EmpleadoService;
import com.serviexpress.serviexpress.negocio.services.ProductoService;
import com.serviexpress.serviexpress.negocio.services.Producto_reservaService;
import com.serviexpress.serviexpress.negocio.services.ReservaService;
import com.serviexpress.serviexpress.negocio.services.Reserva_servicioService;
import com.serviexpress.serviexpress.negocio.services.ServicioService;
import com.serviexpress.serviexpress.vista.resources.vo.ProductoVO;
import com.serviexpress.serviexpress.vista.resources.vo.ReservaVO;
import com.serviexpress.serviexpress.vista.resources.vo.ServicioVO;

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
@RequestMapping("/api/reserva") //el nombre con el cual llamar a esta clase como Servicio web
@Api(tags = "reserva")
public class ReservaResource extends Elohim{
	private final ReservaService rService;
	private final ClienteService clienteService;
	private final EmpleadoService empleadoService;
	private final Reserva_servicioService rsService;
	private final Producto_reservaService prService;
	private final ProductoService pService;
	private final ServicioService sService;
	
	public ReservaResource(
			ReservaService rService,
			ServicioService sService, 
			ClienteService clienteService, 
			EmpleadoService empleadoService,
			Reserva_servicioService rsService,
			Producto_reservaService prService,
			ProductoService pService
	){
		this.rService 			= rService;
		this.clienteService 	= clienteService;
		this.empleadoService	= empleadoService;
		this.rsService 			= rsService;
		this.prService 			= prService;
		this.pService 			= pService;
		this.sService			= sService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear una nueva Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva CREADO correctamente"),@ApiResponse(code = 404, message = "Solicitud Invalida")})
	public ResponseEntity<ReservaVO> createReserva(@RequestBody ReservaVO rVO){
		Reserva rva = new Reserva();
		copiarPropiedadesNoNulas(rVO, rva);
		rva.setEmpleadoReserva(this.empleadoService.findById_empleado(rVO.getId_empleado()));
		rva.setClienteReserva(this.clienteService.findById_cliente(rVO.getId_cliente()));
		rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
		rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
		this.rService.create(rva);
		int idr=this.rService.getLastId();
		rva.setId_reservas(idr);
		if (rVO.getProductos()!=null) {
			for (String pVO : rVO.getProductos()) {
				Producto_reserva pr = new Producto_reserva();
				pr.setId_productos(this.pService.findById_productos(pVO));
				pr.setId_reservas(rva);
				this.prService.create(pr);
			}
		}
		if (rVO.getServicios()!=null) {
			for (Integer sVO : rVO.getServicios()) {
				Reserva_servicio rs = new Reserva_servicio();
				rs.setId_servicios(this.sService.findById_servicios((int)sVO));
				rs.setId_reservas(rva);
				this.rsService.create(rs);
			}
		}
		return new ResponseEntity<>(rVO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_reservas}")
	@ApiOperation(value = "actualizar Reserva", notes = "Servicio para actualizar un Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ACTUALIZADO correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public ResponseEntity<ReservaVO> updateReserva(@PathVariable("id_reservas") int id_reservas, @RequestBody ReservaVO rVO){
		Reserva rva = this.rService.findById_reservas(id_reservas);
		if (rva==null) {
			return new ResponseEntity<ReservaVO>(HttpStatus.NOT_FOUND);
		}else {
			copiarPropiedadesNoNulas(rVO, rva);
			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
			try {
				this.rService.update(rva);
				
				if (rVO.getProductos()!=null) {
					for (String pVO : rVO.getProductos()) {
						Producto_reserva pr = new Producto_reserva();
						pr.setId_productos(this.pService.findById_productos(pVO));
						pr.setId_reservas(rva);
						this.prService.update(pr);
					}
				}
				if (rVO.getServicios()!=null) {
					for (Integer sVO : rVO.getServicios()) {
						Reserva_servicio rs = new Reserva_servicio();
						rs.setId_servicios(this.sService.findById_servicios((int)sVO));
						rs.setId_reservas(rva);
						this.rsService.update(rs);
					}
				}
				
				this.rService.update(rva);

			} catch (Exception e) {
				return new ResponseEntity<ReservaVO>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<>(rVO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_reservas}")
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar una Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ELIMINADa correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public void removeReserva(@PathVariable("id_reservas") int id_reservas) {
		Reserva rva = this.rService.findById_reservas(id_reservas);
		if (rva!=null) {
			this.rService.delete(rva);
		}
	}

 	@GetMapping("/{id_reservas}")
	@ApiOperation(value = "Buscar Reserva", notes = "Reserva para buscar un Reserva")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reserva ENCONTRADO correctamente"),@ApiResponse(code = 404, message = "Reserva NO encontrado")})
	public ResponseEntity<ReservaVO> findById_Reservas(int id_reservas) {
		Reserva rva = this.rService.findById_reservas(id_reservas);
		ReservaVO rVO = new ReservaVO();
		copiarPropiedadesNoNulas(rva,rVO);
		rVO.setId_reservas(rva.getId_reservas());
		rVO.setFecha(rva.getFecha());
		rVO.setObservaciones(rva.getObservaciones());
		rVO.setSe_atendio(rva.getSe_atendio());
		rVO.setId_cliente(rva.getClienteReserva().getId_cliente());
		rVO.setId_empleado(rva.getEmpleadoReserva().getId_empleado());
		rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
		rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
		if (rva.getrProductoReserva()!=null) {
				List<String> prodsVO =new ArrayList();
			for (Producto_reserva prva : rva.getrProductoReserva()) {
				ProductoVO pVO = new ProductoVO();
				Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
				copiarPropiedadesNoNulas(pro, pVO);
				prodsVO.add(pVO.getId_productos());
			}
			rVO.setProductos(prodsVO);
		}
			if (rva.getrReserva_servicio()!=null) {
				List<Integer> servsVO =new ArrayList();
			for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
				ServicioVO sVO = new ServicioVO();
				Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
				copiarPropiedadesNoNulas(serv, sVO);
				servsVO.add(sVO.getId_servicios());
			}
			rVO.setServicios(servsVO);
		}
		return ResponseEntity.ok(rVO);
	}
 
 	@GetMapping
	@ApiOperation(value = "Listar Reservas", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<ReservaVO>> findAll() {
 		List<Reserva>reservas = this.rService.findAll();
 		List<ReservaVO> rVos = new ArrayList();
 		
 		for (Reserva rva : reservas) {
 			ReservaVO rVO = new ReservaVO();
 			copiarPropiedadesNoNulas(rva,rVO);
 			rVO.setId_reservas(rva.getId_reservas());
 			rVO.setFecha(rva.getFecha());
 			rVO.setObservaciones(rva.getObservaciones());
 			rVO.setSe_atendio(rva.getSe_atendio());
 			rVO.setId_cliente(rva.getClienteReserva().getId_cliente());
 			rVO.setId_empleado(rva.getEmpleadoReserva().getId_empleado());
 			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
 			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
 			if (rva.getrProductoReserva()!=null) {
 				List<String> prodsVO =new ArrayList();
				for (Producto_reserva prva : rva.getrProductoReserva()) {
					ProductoVO pVO = new ProductoVO();
					Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
					copiarPropiedadesNoNulas(pro, pVO);
					prodsVO.add(pVO.getId_productos());
				}
				rVO.setProductos(prodsVO);
			}
 			if (rva.getrReserva_servicio()!=null) {
 				List<Integer> servsVO =new ArrayList();
				for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
					ServicioVO sVO = new ServicioVO();
					Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
					copiarPropiedadesNoNulas(serv, sVO);
					servsVO.add(sVO.getId_servicios());
				}
				rVO.setServicios(servsVO);
			}
 			rVos.add(rVO);
		}
		return ResponseEntity.ok(rVos);
		
	}
 	
 	@GetMapping("/atendidas")
	@ApiOperation(value = "Listar Reservas Atendidas", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<ReservaVO>> findReservasAtendidas() {
 		List<Reserva>reservas = this.rService.findReservasAtendidas();
 		List<ReservaVO> rVos = new ArrayList();
 		
 		for (Reserva rva : reservas) {
 			ReservaVO rVO = new ReservaVO();
 			copiarPropiedadesNoNulas(rva,rVO);
 			rVO.setId_reservas(rva.getId_reservas());
 			rVO.setFecha(rva.getFecha());
 			rVO.setObservaciones(rva.getObservaciones());
 			rVO.setSe_atendio(rva.getSe_atendio());
 			rVO.setId_cliente(rva.getClienteReserva().getId_cliente());
 			rVO.setId_empleado(rva.getEmpleadoReserva().getId_empleado());
 			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
 			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
 			if (rva.getrProductoReserva()!=null) {
 				List<String> prodsVO =new ArrayList();
				for (Producto_reserva prva : rva.getrProductoReserva()) {
					ProductoVO pVO = new ProductoVO();
					Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
					copiarPropiedadesNoNulas(pro, pVO);
					prodsVO.add(pVO.getId_productos());
				}
				rVO.setProductos(prodsVO);
			}
 			if (rva.getrReserva_servicio()!=null) {
 				List<Integer> servsVO =new ArrayList();
				for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
					ServicioVO sVO = new ServicioVO();
					Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
					copiarPropiedadesNoNulas(serv, sVO);
					servsVO.add(sVO.getId_servicios());
				}
				rVO.setServicios(servsVO);
			}
 			rVos.add(rVO);
		}
		return ResponseEntity.ok(rVos);
		
	}
 	
 	@GetMapping("/sinatender")
	@ApiOperation(value = "Listar Reservas Sin Atender", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<ReservaVO>> findReservasSinAtender() {
 		List<Reserva>reservas = this.rService.findReservasSinAtender();
 		List<ReservaVO> rVos = new ArrayList();
 		
 		for (Reserva rva : reservas) {
 			ReservaVO rVO = new ReservaVO();
 			copiarPropiedadesNoNulas(rva,rVO);
 			rVO.setId_reservas(rva.getId_reservas());
 			rVO.setFecha(rva.getFecha());
 			rVO.setObservaciones(rva.getObservaciones());
 			rVO.setSe_atendio(rva.getSe_atendio());
 			rVO.setId_cliente(rva.getClienteReserva().getId_cliente());
 			rVO.setId_empleado(rva.getEmpleadoReserva().getId_empleado());
 			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
 			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
 			if (rva.getrProductoReserva()!=null) {
 				List<String> prodsVO =new ArrayList();
				for (Producto_reserva prva : rva.getrProductoReserva()) {
					ProductoVO pVO = new ProductoVO();
					Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
					copiarPropiedadesNoNulas(pro, pVO);
					prodsVO.add(pVO.getId_productos());
				}
				rVO.setProductos(prodsVO);
			}
 			if (rva.getrReserva_servicio()!=null) {
 				List<Integer> servsVO =new ArrayList();
				for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
					ServicioVO sVO = new ServicioVO();
					Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
					copiarPropiedadesNoNulas(serv, sVO);
					servsVO.add(sVO.getId_servicios());
				}
				rVO.setServicios(servsVO);
			}
 			rVos.add(rVO);
		}
		return ResponseEntity.ok(rVos);
	}
 	
 	@GetMapping("/findReservasByCliente")
	@ApiOperation(value = "Listar Reservas", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<ReservaVO>> findReservasByCliente(int id_cliente) {
 		List<Reserva>reservas = (this.rService.findReservasByCliente(id_cliente));
 		List<ReservaVO> rVos = new ArrayList();
		for (Reserva rva : reservas) {
			ReservaVO rVO = new ReservaVO();
			copiarPropiedadesNoNulas(rva,rVO);
			rVO.setId_reservas(rva.getId_reservas());
			rVO.setFecha(rva.getFecha());
			rVO.setObservaciones(rva.getObservaciones());
			rVO.setSe_atendio(rva.getSe_atendio());
			rVO.setId_cliente(id_cliente);
			rVO.setId_empleado(rva.getEmpleadoReserva().getId_empleado());
			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
			if (rva.getrProductoReserva()!=null) {
 				List<String> prodsVO =new ArrayList();
				for (Producto_reserva prva : rva.getrProductoReserva()) {
					ProductoVO pVO = new ProductoVO();
					Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
					copiarPropiedadesNoNulas(pro, pVO);
					prodsVO.add(pVO.getId_productos());
				}
				rVO.setProductos(prodsVO);
			}
 			if (rva.getrReserva_servicio()!=null) {
 				List<Integer> servsVO =new ArrayList();
				for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
					ServicioVO sVO = new ServicioVO();
					Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
					copiarPropiedadesNoNulas(serv, sVO);
					servsVO.add(sVO.getId_servicios());
				}
				rVO.setServicios(servsVO);
			}
			rVos.add(rVO);
		}
		return ResponseEntity.ok(rVos);
	}
 	@GetMapping("/findReservasByEmpleado")
	@ApiOperation(value = "Listar Reservas", notes = "Reserva para listar todos los Reservas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Reservas ENCONTRADOS correctamente"),@ApiResponse(code = 404, message = "Reservas NO encontrado")})
	public ResponseEntity<List<ReservaVO>> findReservasByEmpleado(int id_empleado) {
 		List<Reserva>reservas = (this.rService.findReservasByEmpleado(id_empleado));
 		List<ReservaVO> rVos = new ArrayList();
		for (Reserva rva : reservas) {
			ReservaVO rVO = new ReservaVO();
			copiarPropiedadesNoNulas(rva,rVO);
			rVO.setId_reservas(rva.getId_reservas());
			rVO.setFecha(rva.getFecha());
			rVO.setObservaciones(rva.getObservaciones());
			rVO.setSe_atendio(rva.getSe_atendio());
			rVO.setId_cliente(rva.getClienteReserva().getId_cliente());
			rVO.setId_empleado(id_empleado);
			rVO.setNombreCliente(rva.getClienteReserva().getPersonaCliente().getNombre());
			rVO.setNombreCliente(rva.getEmpleadoReserva().getPersonaEmpleado().getNombre());
			if (rva.getrProductoReserva()!=null) {
 				List<String> prodsVO =new ArrayList();
				for (Producto_reserva prva : rva.getrProductoReserva()) {
					ProductoVO pVO = new ProductoVO();
					Producto pro = this.pService.findById_productos(prva.getId_productos().getId_productos());
					copiarPropiedadesNoNulas(pro, pVO);
					prodsVO.add(pVO.getId_productos());
				}
				rVO.setProductos(prodsVO);
			}
 			if (rva.getrReserva_servicio()!=null) {
 				List<Integer> servsVO =new ArrayList();
				for (Reserva_servicio rserv : rva.getrReserva_servicio()) {
					ServicioVO sVO = new ServicioVO();
					Servicio serv = this.sService.findById_servicios(rserv.getId_servicios().getId_servicios());
					copiarPropiedadesNoNulas(serv, sVO);
					servsVO.add(sVO.getId_servicios());
				}
				rVO.setServicios(servsVO);
			}
			rVos.add(rVO);
		}
		return ResponseEntity.ok(rVos);
	}
}
