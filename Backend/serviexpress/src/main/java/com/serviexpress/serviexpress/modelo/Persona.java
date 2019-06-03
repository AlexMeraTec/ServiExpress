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
@Table(name = "personas")
@NamedQuery(name = "Persona.findById_persona", query = "select p from Persona p where p.id_personas = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
@NamedQuery(name = "Persona.findByRut", query = "select p from Persona p where p.rut = ?1 and p.digito_verificador = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
public class Persona {
	@Id
	@Column(name = "id_personas")
	private int id_personas;
	
	@Column(name = "rut")
	private int rut;
	
	@Column(name = "digito_verificador")
	private char digito_verificador;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "paterno")
	private String paterno;
	
	@Column(name = "materno")
	private String materno;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "telefono2")
	private int telefono2 = 0;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "e_mail")
	private String e_mail;
	
	@Column(name = "activa")
	private boolean activa;
	
	@Column(name = "tipo_personas")
	private char tipo_personas;
	
}
