package com.jdc.onestop.criteria.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentListItem(
		int doctorId, 
		String doctorName, 
		int patientId,
		String patientName, 
		String patientPhone, 
		LocalDate appointmentDate, 
		String startTime, 
		int seqNumber,
		LocalDateTime registAt) {

}
