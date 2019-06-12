package com.serviexpress.serviexpress.vista.resources.vo;


import lombok.Data;
/**
 * @author arekkusu888
 *
 */
@Data
public class PersonaVO {
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
	private int tipo_personas;
}
