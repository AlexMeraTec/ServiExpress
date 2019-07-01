package com.serviexpress.serviexpress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiexpressApplicationTests {

	@Test
	public void contextLoads() {
	}
//	@Test
//	public void LOGINUSER() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("application");
//		EntityManager em = emf.createEntityManager();
//	    em.getTransaction().begin();
//	       
//		// define the stored procedure
//		StoredProcedureQuery query = em.createStoredProcedureQuery("LOGINUSER");
//		query.registerStoredProcedureParameter("v_username", Double.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("v_password", Double.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("validador", Double.class, ParameterMode.OUT);
//		
//		// set input parameter
//		query.setParameter("v_username", "online");
//		query.setParameter("v_password", "online");
//		
//		// call the stored procedure and get the result
//		query.execute();
//		int sum = (int) query.getOutputParameterValue("validador");	
//		em.getTransaction().commit();
//		em.close();
//	}
}
