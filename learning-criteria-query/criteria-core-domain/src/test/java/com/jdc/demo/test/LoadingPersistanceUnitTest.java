package com.jdc.demo.test;

import org.junit.jupiter.api.Test;

import com.jdc.onestop.criteria.entity.Account;
import com.jdc.onestop.criteria.enums.Role;

import jakarta.persistence.Persistence;

public class LoadingPersistanceUnitTest {
	
	@Test
	void test_loading() {
		
		var emf = Persistence.createEntityManagerFactory("criteria-core-domain");
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		var account = new Account();
		account.setLoginId("admin@gmail.com");
		account.setPassword("admin");
		account.setRole(Role.Administrator);
		account.setActivated(true);
		
		em.persist(account);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
