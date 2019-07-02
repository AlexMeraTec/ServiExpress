package com.serviexpress.serviexpress.vista.resources.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private boolean tipo;
	public int getId_personas() {
		return id_personas;
	}
	public void setId_personas(int id_personas) {
		this.id_personas = id_personas;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public char getDigito_verificador() {
		return digito_verificador;
	}
	public void setDigito_verificador(char digito_verificador) {
		this.digito_verificador = digito_verificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
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
	public int getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
//	@JsonIgnore
//	private ClienteVO cVO;
//	
//	@JsonIgnore
//	private EmpleadoVO eVO;
}
