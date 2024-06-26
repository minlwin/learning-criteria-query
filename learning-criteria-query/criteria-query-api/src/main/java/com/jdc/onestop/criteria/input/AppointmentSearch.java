package com.jdc.onestop.criteria.input;

import java.time.LocalDate;

public record AppointmentSearch(
		// Ignore case and start with
		String doctorName,
		// Ignore case and start with
		String patientName,
		// Ignore case and start with
		String patientPhone,
		String startTime,
		LocalDate from,
		LocalDate to,
		Boolean canceled
) {

}
