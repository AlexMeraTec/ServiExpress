package com.serviexpress.serviexpress.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "recepciones")
@NamedQuery(name = "Recepcion.findById_recepcion", query = "select r from Recepcion r where r.id_recepcion = ?1")
public class Recepcion {

	@Id
	@Column(name = "id_recepcion")
	private int id_recepcion;
	
	@Column(name = "pedidos_id_pedidos")
	private int pedidos_id_pedidos;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "id_emp_recep")
	private int id_emp_recep;
}
