package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "tipos")
@NamedQuery(name = "Tipo.findById_tipos", query = "select t from Tipo t where t.id_tipos = ?1")
public class Tipo{
	@Id
	@Column(name = "id_tipos")
	private int id_tipos;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "activo")
	private String activo;
}
