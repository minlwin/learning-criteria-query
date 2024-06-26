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
public class DoctorAppointmentPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "doctor_id")
	private int doctorId;

	@Override
	public int hashCode() {
		return Objects.hash(appointmentDate, doctorId, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorAppointmentPk other = (DoctorAppointmentPk) obj;
		return Objects.equals(appointmentDate, other.appointmentDate) && doctorId == other.doctorId
				&& Objects.equals(startTime, other.startTime);
	}

}
