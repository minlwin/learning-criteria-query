package com.jdc.onestop.criteria.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contact {
	
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	
	@Column(name = "extra_phone")
	private String extraPhone;
}
