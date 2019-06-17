package com.serviexpress.serviexpress.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas_servicios")
@IdClass(value = IntCompuesta.class)
@NamedQuery(name = "Reserva_servicio.findByReserva_servicio_id_reservas", query = "select rs from Reserva_servicio rs where rs.id_reservas = ?1 and rs.id_servicios = ?1 ")
public class Reserva_servicio {

//	@Id
//	@Column(name = "id_reservas", updatable = false, nullable = false)
//	private int id_reservas;
//	@Id
//	@Column(name = "id_servicios", updatable = false, nullable = false)
//	private int id_servicios;
//	

//	List<Reserva> reservas_id_reservas; 
//	List<Servicio> servicios_id_servicios;
//	List<Reserva> reservasServicios;
//	@EmbeddedId
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_reservas", updatable = false, nullable = false)
	private Reserva id_reservas;
	@Id
	@ManyToOne
	@JoinColumn(name = "id_servicios", updatable = false, nullable = false)
	private Servicio id_servicios;
}
