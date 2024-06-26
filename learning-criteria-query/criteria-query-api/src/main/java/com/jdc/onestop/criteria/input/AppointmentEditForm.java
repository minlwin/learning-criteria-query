package com.jdc.onestop.criteria.input;

import java.time.LocalDate;

public record AppointmentEditForm(
		int doctorId,
		LocalDate date,
		String startTime,
		int patientId,
		String reason) {

}
