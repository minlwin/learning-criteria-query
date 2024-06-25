package com.jdc.onestop.criteria.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.onestop.criteria.enums.Gender;

public record PatientListItem(
		int id,
		String name,
		String phone,
		String email,
		Gender gender,
		LocalDate dob,
		LocalDateTime registA) {

}
