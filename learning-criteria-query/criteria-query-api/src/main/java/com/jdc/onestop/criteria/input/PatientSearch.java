package com.jdc.onestop.criteria.input;

import java.time.LocalDate;

public record PatientSearch(
		String name,
		String phone,
		LocalDate from,
		LocalDate to) {

}
