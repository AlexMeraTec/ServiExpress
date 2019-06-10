package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas_servicios")
@NamedQuery(name = "Reserva_servicio.findByReserva_servicio_id_reservas", query = "select rs from Reserva_servicio rs where rs.reservas_id_reservas = ?1")
public class Reserva_servicio {
	@Id
	@Column(name = "reservas_id_reservas")
	private int reservas_id_reservas;
	
	@Column(name = "servicios_id_servicios")
	private int servicios_id_servicios;
}
