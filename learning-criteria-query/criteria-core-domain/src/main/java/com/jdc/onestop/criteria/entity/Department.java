package com.jdc.onestop.criteria.entity;

import com.jdc.onestop.criteria.embeddable.Contact;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	private String code;
	
	@Column(nullable = false)
	private String name;
	
	@Basic(optional = false)
	private Contact contact;
}
