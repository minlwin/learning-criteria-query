package com.jdc.onestop.criteria.entity;

import com.jdc.onestop.criteria.embeddable.DoctorAppointmentPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DOCTOR_APPOINTMENT")
public class DoctorAppointment {

	@EmbeddedId
	private DoctorAppointmentPk id;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Doctor doctor;
	
	@Column(nullable = false)
	private boolean available = true;
}
