package com.jdc.onestop.criteria.entity;

import java.util.List;

import com.jdc.onestop.criteria.embeddable.Contact;
import com.jdc.onestop.criteria.embeddable.Schedule;
import com.jdc.onestop.criteria.enums.Gender;

import jakarta.persistence.Basic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DOCTOR")
@SequenceGenerator(name = "DOCTOR_SEQ", allocationSize = 1)
public class Doctor {

	@Id
	@GeneratedValue(generator = "DOCTOR_SEQ")
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Account account;
	
	@Column(nullable = false)
	private String degree;

	@Column(nullable = false)
	private Gender gender;
	
	@Basic(optional = false)
	private Contact contact;
	
	@ManyToMany
	private List<Department> department;
	
	@ElementCollection
	@CollectionTable(name = "DOCTOR_SCHEDULE", joinColumns = @JoinColumn(name = "doctor_id"))
	private List<Schedule> schedule;
	
}
