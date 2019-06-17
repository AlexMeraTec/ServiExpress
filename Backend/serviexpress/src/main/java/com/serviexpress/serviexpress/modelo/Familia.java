package com.serviexpress.serviexpress.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "familias")
@NamedQuery(name = "Familia.findById_familias", query = "select f from Familia f where f.id_familias = ?1")
public class Familia{
	@Id
	@Column(name = "id_familias")
	private int id_familias;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "activa")
	private boolean activa;
	
	@OneToMany(mappedBy = "id_familias",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Producto> productoFamilia; 
}