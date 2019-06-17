package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class PagoVO {
	
	private int id_pago;
	private Date fecha;
	private boolean boleta_factura;
	private int total_neto;
	private int descuento;
	private int total_final;
	private boolean anulada;
	private int reservas_id_reservas;
	
}