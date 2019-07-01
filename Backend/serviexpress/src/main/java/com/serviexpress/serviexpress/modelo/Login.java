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
	private String v_username;
	private String v_password;
	private String msj;
	private int si;

	public Login(String v_username, String v_password) {
      this.v_username = v_username;
      this.v_password = v_password;
  }
  
	
//	Logger log = Logger.getLogger(this.getClass().getName().toString());
//	
//	private EntityManagerFactory emf;
//
//    
//    public Login() {
//        emf = Persistence.createEntityManagerFactory("Workbench");
//    }
//    
//    public Login(String v_username, String v_password) {
//        emf = Persistence.createEntityManagerFactory("Workbench");
//        this.v_username = v_username;
//        this.v_password = v_password;
//    }
//    
//    public void close() {
//        emf.close();
//    }
//	
//	
//	public void LOGINUSER() {
//		log.info("... LOGINUSER ...");
//		EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//		// define the stored procedure
//		StoredProcedureQuery query = em.createStoredProcedureQuery("LOGINUSER");
//		query.registerStoredProcedureParameter("v_username", String.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("v_password", String.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("msj", String.class, ParameterMode.OUT);
//		query.registerStoredProcedureParameter("si", int.class, ParameterMode.OUT);
//		
//		// set input parameter
//		query.setParameter("v_username", this.v_username );
//		query.setParameter("v_password", this.v_password);
//		// call the stored procedure and get the result
//		query.execute();
//		String msj = (String) query.getOutputParameterValue("msj");
//		int si = (int) query.getOutputParameterValue("si");
//		log.info("Calculation result: " + msj +" SI:"+si);
//        em.getTransaction().commit();
//        em.close();
//	}
}