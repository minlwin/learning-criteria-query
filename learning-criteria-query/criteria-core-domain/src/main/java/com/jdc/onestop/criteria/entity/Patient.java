package com.jdc.onestop.criteria.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.onestop.criteria.embeddable.Contact;
import com.jdc.onestop.criteria.enums.Gender;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PATIENT")
@SequenceGenerator(name = "PATIENT_SEQ", allocationSize = 1)
public class Patient {

	@Id
	@GeneratedValue(generator = "PATIENT_SEQ")
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Account account;
	
	@Basic(optional = false)
	private Contact contact;

	private Gender gender;
	
	private LocalDate dob;
	private String address;

	@Column(nullable = false, name = "regist_at")
	private LocalDateTime registAt;
}
