/**
 * 
 */
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
@Table(name = "proveedores")
@NamedQuery(name = "Proveedor.findById_proveedor", query = "select p from Proveedor p where p.id_proveedor = ?1")
public class Proveedor {
	@Id
	@Column(name = "id_proveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name = "activo")
	private boolean activo;
	
	@OneToMany(mappedBy = "id_proveedor",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private List<Producto> productosProveedor;

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Producto> getProductosProveedor() {
		return productosProveedor;
	}

	public void setProductosProveedor(List<Producto> productosProveedor) {
		this.productosProveedor = productosProveedor;
	}
	
}
