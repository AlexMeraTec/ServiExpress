/**
 * 
 */
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
@Table(name = "proveedores")
@NamedQuery(name = "Proveedor.findById_proveedor", query = "select p from Proveedor p where p.id_proveedor = ?1")
public class Proveedor {
	@Id
	@Column(name = "id_proveedor")
	private int id_proveedor;
	
	@Column(name = "rubro")
	private String rubro;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "e_mail")
	private String e_mail;
	
}
