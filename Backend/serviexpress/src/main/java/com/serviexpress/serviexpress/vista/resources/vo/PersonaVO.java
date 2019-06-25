package com.serviexpress.serviexpress.vista.resources.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class PersonaVO {
	@JsonIgnore
	private int id_personas;
	
	private int rut;
	private char digito_verificador;
	private String nombre;
	private String paterno;
	private String materno;
	private String direccion;
	private int telefono;
	private int telefono2;
	private String usuario;
	private String password;
	private String e_mail;
	private boolean activa;
	private boolean tipo;
	
//	@JsonIgnore
//	private ClienteVO cVO;
//	
//	@JsonIgnore
//	private EmpleadoVO eVO;
}
