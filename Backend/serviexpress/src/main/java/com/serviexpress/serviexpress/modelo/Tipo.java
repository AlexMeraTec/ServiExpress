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
@Table(name = "tipos")
@NamedQuery(name = "Tipo.findById_tipos", query = "select t from Tipo t where t.id_tipos = ?1")
public class Tipo{
	@Id
	@Column(name = "id_tipos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipos;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "activo")
	private boolean activo;
	
	@OneToMany(mappedBy = "id_tipos",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private List<Producto> productosTipo;
}
