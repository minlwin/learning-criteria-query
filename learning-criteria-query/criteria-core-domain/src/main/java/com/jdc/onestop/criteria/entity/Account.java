package com.jdc.onestop.criteria.entity;

import com.jdc.onestop.criteria.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@Column(name = "login_id")
	private String loginId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;

	private boolean activated;
}
