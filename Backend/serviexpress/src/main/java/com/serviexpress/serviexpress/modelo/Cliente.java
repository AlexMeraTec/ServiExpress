package com.serviexpress.serviexpress.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@PrimaryKeyJoinColumn(name="id_personas")
@Table(name = "clientes")
@NamedQuery(name = "Cliente.findById_personas", query = "select c from Cliente c where c.id_personas = ?1")
public class Cliente{
	@Id
	@Column(name = "id_personas")
	private int id_personas;
	@Column(name = "natural_empresa")
	private boolean natural_empresa;//0 para natural y 1 para empresa
	
	/*
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Persona persona;}
	*/
}
