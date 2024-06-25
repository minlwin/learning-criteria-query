package com.jdc.onestop.criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.onestop.criteria.input.PatientSearch;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PatientServiceTest {

	private static EntityManagerFactory EMF;
	private PatientService service;

	@ParameterizedTest
	@CsvSource({ 
		",,,,6",
		"Kyaw,,,,2",
		",091122334,,,1",
		",,2024-01-01,,3",
		",,,2024-01-01,3",
		"Kyaw,091122334,2024-01-01,2024-05-10,1",
		"Pyae,091122334,2024-01-01,2024-05-10,0",
	})
	void test_search(String name, String phone, LocalDate from, LocalDate to, int size) {
		var input = new PatientSearch(name, phone, from, to);
		var result = service.search(input);
		
		assertEquals(size, result.size());
	}

	@BeforeAll
	static void start() {
		EMF = Persistence.createEntityManagerFactory("criteria-core-domain");
	}

	@AfterAll
	static void end() {
		EMF.close();
	}

	@BeforeEach
	void init() {
		service = new PatientServiceImpl(EMF::createEntityManager);
	}

}
