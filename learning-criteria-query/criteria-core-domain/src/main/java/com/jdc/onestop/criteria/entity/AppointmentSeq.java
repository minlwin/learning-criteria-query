package com.jdc.onestop.criteria.entity;

import com.jdc.onestop.criteria.embeddable.DoctorAppointmentPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "APPOINTMENT_SEQ")
public class AppointmentSeq {

	@EmbeddedId
	private DoctorAppointmentPk id;
	
	@Column(nullable = false, name = "seq_number")
	private int seqNumber;
}
