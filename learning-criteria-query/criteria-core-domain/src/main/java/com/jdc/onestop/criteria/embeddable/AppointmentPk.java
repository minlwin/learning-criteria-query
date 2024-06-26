package com.jdc.onestop.criteria.embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "patient_id")
	private int patientId;

	public AppointmentPk(DoctorAppointmentPk pk, int patientId) {
		this.doctorId = pk.getDoctorId();
		this.appointmentDate = pk.getAppointmentDate();
		this.startTime = pk.getStartTime();
		this.patientId = patientId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentDate, doctorId, patientId, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentPk other = (AppointmentPk) obj;
		return Objects.equals(appointmentDate, other.appointmentDate) && doctorId == other.doctorId
				&& patientId == other.patientId && Objects.equals(startTime, other.startTime);
	}
}
