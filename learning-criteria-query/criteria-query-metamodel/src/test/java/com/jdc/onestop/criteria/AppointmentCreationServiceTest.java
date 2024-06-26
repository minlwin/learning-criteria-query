package com.jdc.onestop.criteria;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.onestop.criteria.input.AppointmentEditForm;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(value = OrderAnnotation.class)
public class AppointmentCreationServiceTest {
	
	private AppointmentService service;
	private static EntityManagerFactory EMF;

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"3,,,1,Test Reason,Please select appointment date.",
		"3,2024-06-10,,1,Test Reason,Please select today or future date for apointment date.",
		"3,1900-01-01,,1,Test Reason,Please select start time.",
	})
	void test_fail_invalid_inputs(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message, exception.getMessage());
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"5,1900-01-01,16:00,1,Test Reason,There is no doctor with id %s."
	})
	void test_fail_no_doctor(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message.formatted(doctorId), exception.getMessage());
	}

	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"3,1900-01-01,16:00,7,Test Reason,There is no patient with id 7."
	})
	void test_fail_no_patient(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message, exception.getMessage());
	}

	@Order(4)
	@ParameterizedTest
	@CsvSource({
		"3,1900-01-01,09:00,1,Test Reason,There is no schedule for %s 09:00."
	})
	void test_fail_no_schedule(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message.formatted(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), exception.getMessage());
	}

	@Order(5)
	@ParameterizedTest
	@CsvSource({
		"4,1900-01-01,16:00,1,Test Reason,1",
		"4,1900-01-01,16:00,2,Test Reason,2",
		"4,1900-01-01,16:00,3,Test Reason,3",
		"4,1900-01-01,16:00,4,Test Reason,4",
		"4,1900-01-01,16:00,5,Test Reason,5",
		"3,1900-01-01,16:00,1,Test Reason,1",
	})
	void test_success(int doctorId, LocalDate date, String startTime, int patientId, String reason, int seqNumber) {
		assertDoesNotThrow(() -> {
			var result = service.create(new AppointmentEditForm(doctorId, 
					LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, 
							startTime, patientId, reason));
			assertEquals(seqNumber, result.seqNumber());
		});
	}
	
	@Order(6)
	@ParameterizedTest
	@CsvSource({
		"4,1900-01-01,16:00,1,Test Reason,You'd already taken appointment for %s %s.",
		"4,1900-01-01,16:00,2,Test Reason,You'd already taken appointment for %s %s.",
		"4,1900-01-01,16:00,3,Test Reason,You'd already taken appointment for %s %s.",
		"4,1900-01-01,16:00,4,Test Reason,You'd already taken appointment for %s %s.",
		"4,1900-01-01,16:00,5,Test Reason,You'd already taken appointment for %s %s.",
	})
	void test_fail_double_booking(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message.formatted(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), startTime), exception.getMessage());
	}

	@Order(7)
	@ParameterizedTest
	@CsvSource({
		"3,1900-01-01,16:00,2,Test Reason,Doctor can't accept appointment for %s %s.",
	})
	void test_fail_max_limit(int doctorId, LocalDate date, String startTime, int patientId, String reason, String message) {
		var exception = assertThrows(HospitalBusinessException.class, () -> {
			service.create(new AppointmentEditForm(doctorId, LocalDate.of(1900, 1, 1).equals(date) ? LocalDate.now() : date, startTime, patientId, reason));
		});
		
		assertEquals(message.formatted(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), startTime), exception.getMessage());
	}

	@BeforeAll
	static void start() {
		EMF = Persistence.createEntityManagerFactory("criteria-core-domain");
	}
	
	@BeforeEach
	void init() {
		service = new AppointmentServiceImpl(EMF::createEntityManager);
	}
	
	@AfterAll
	static void end() {
		EMF.close();
	}	
}
