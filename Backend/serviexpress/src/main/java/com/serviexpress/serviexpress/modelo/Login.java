package com.serviexpress.serviexpress.modelo;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import lombok.Data;

@Data
public class Login {
	private String usuario;
	private String password;
	public Login(String usuario, String password) {
      this.usuario = usuario;
      this.password = password;
  }
}