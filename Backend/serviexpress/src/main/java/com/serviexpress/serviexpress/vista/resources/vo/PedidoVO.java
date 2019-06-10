package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class PedidoVO {
	private int id_pedidos;
	private boolean estado;
	private int empleados_id_personas;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

}
