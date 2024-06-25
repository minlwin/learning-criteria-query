package com.jdc.onestop.criteria.embeddable;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DoctorAppointmentPk {

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "doctor_id")
	private int doctorId;
}
