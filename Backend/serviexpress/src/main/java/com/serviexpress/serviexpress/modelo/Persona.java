package com.serviexpress.serviexpress.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Persona.findById_personas", query = "select p from Persona p where p.id_personas = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
@NamedQuery(name = "Persona.findByRut", query = "select p from Persona p where p.rut = ?1 and p.digito_verificador = ?1") //no olvidar que from Producto es con mayuscula porque es la CLASE
public class Persona {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_PERSONA")
	@Column(name = "id_personas")
	private int id_personas;
	
	@Column(name = "rut",unique = true)
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
	
	@Column(name = "usuario",unique = true)
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "e_mail",unique = true)
	private String e_mail;
	
	@Column(name = "activa")
	private boolean activa;
	
	@Column(name = "tipo",nullable = false)
	private boolean tipo;

	@OneToOne(mappedBy = "personaCliente",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private Cliente cliente;
	
	@OneToOne(mappedBy = "personaEmpleado",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private Empleado empleado;

}
