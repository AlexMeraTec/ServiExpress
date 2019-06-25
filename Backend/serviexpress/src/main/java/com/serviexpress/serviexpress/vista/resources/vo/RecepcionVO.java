package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class RecepcionVO {
	private int id_recepcion;
	private int pedidos_id_pedidos;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private int cantidad;
	private int id_emp_recep;
	
	private PedidoVO pedidovo;
}