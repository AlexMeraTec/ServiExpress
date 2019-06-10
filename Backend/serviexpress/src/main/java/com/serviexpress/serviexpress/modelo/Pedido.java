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
@Table(name = "pedidos")
@NamedQuery(name = "Pedido.findById_pedidos", query = "select p from Pedido p where p.id_pedidos = ?1")
public class Pedido {
	@Id
	@Column(name = "id_pedidos")
	private int id_pedidos;

	@Column(name = "estado")
	private boolean estado;

	@Column(name = "empleados_id_personas")
	private int empleados_id_personas;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

}
