package com.jdc.onestop.criteria.entity;

import java.time.LocalDateTime;

import com.jdc.onestop.criteria.embeddable.AppointmentPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

	@EmbeddedId
	private AppointmentPk id;
	
	@Column(name = "seq_number")
	private int seqNumber;
	
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false, insertable = false)
	private Doctor doctor;

	@ManyToOne(optional = false)
	@JoinColumn(updatable = false, insertable = false)
	private Patient patient;
	
	private boolean cancled;
	
	@Column(name = "regist_at")
	private LocalDateTime registAt;
	
	@Column(name = "canceld_at")
	private LocalDateTime canceldAt;
	
	private String reason;
	
	@Column(name = "cancel_reason")
	private String cancelReason;
	
}
