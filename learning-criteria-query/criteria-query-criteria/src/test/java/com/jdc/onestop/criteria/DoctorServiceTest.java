package com.jdc.onestop.criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.onestop.criteria.input.DoctorSearch;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DoctorServiceTest {

	private static EntityManagerFactory EMF;
	private DoctorService service;
	
	@ParameterizedTest
	@CsvSource({
		",,,,4",
		"icu,,,,3",
		",Aung,,,1",
		",,MBBS,,1",
		",,,MONDAY,3",
		"icu,Aung,MBBS,MONDAY,1",
		
	})
	void test_search(String code, String name, String degree, DayOfWeek day, int size) {
		var result = service.search(new DoctorSearch(code, name, degree, day));
		assertEquals(size, result.size());
	}
	
	@BeforeAll
	static void start() {
		EMF = Persistence.createEntityManagerFactory("criteria-core-domain");
	}
	
	@BeforeEach
	void init() {
		service = new DoctorServiceImpl(EMF::createEntityManager);
	}
	
	@AfterAll
	static void end() {
		EMF.close();
	}
}
