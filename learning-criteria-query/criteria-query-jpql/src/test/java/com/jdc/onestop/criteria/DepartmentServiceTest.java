package com.jdc.onestop.criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.onestop.criteria.input.DepartmentSearch;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DepartmentServiceTest {

	private static EntityManagerFactory EMF;
	
	private DepartmentService service;
	
	@ParameterizedTest
	@CsvSource({
		",,,10",
		"ACE,,,1",
		",c,,2",
		",,091111222,8",
		"ACE,a,091111222,1",
		"ACE,ad,091111222,0",		
	})
	void test_search(String code, String name, String phone, int size) {
		
		var result = service.search(new DepartmentSearch(code, name, phone));
		assertEquals(size, result.size());
	}
	
	@BeforeAll
	static void start() {
		EMF = Persistence.createEntityManagerFactory("criteria-core-domain");
	}
	
	@BeforeEach
	void init() {
		service = new DepartmentServiceImpl(EMF::createEntityManager);
	}
	
	@AfterAll
	static void end() {
		EMF.close();
	}
}
