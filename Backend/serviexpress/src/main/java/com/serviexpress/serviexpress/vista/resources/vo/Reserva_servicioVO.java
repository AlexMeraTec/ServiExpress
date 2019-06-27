package com.serviexpress.serviexpress.vista.resources.vo;
import lombok.Data;

@Data
public class Reserva_servicioVO {
	private int reservas_id_reservas;
	private int servicios_id_servicios;
	public int getReservas_id_reservas() {
		return reservas_id_reservas;
	}
	public void setReservas_id_reservas(int reservas_id_reservas) {
		this.reservas_id_reservas = reservas_id_reservas;
	}
	public int getServicios_id_servicios() {
		return servicios_id_servicios;
	}
	public void setServicios_id_servicios(int servicios_id_servicios) {
		this.servicios_id_servicios = servicios_id_servicios;
	}
	
}
