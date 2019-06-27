package com.serviexpress.serviexpress.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_familias;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "activa")
	private boolean activa;
	
	@OneToMany(mappedBy = "id_familias",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Producto> productoFamilia;

	public int getId_familias() {
		return id_familias;
	}

	public void setId_familias(int id_familias) {
		this.id_familias = id_familias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public List<Producto> getProductoFamilia() {
		return productoFamilia;
	}

	public void setProductoFamilia(List<Producto> productoFamilia) {
		this.productoFamilia = productoFamilia;
	}
	
}
