package com.jdc.onestop.criteria.input;

import java.time.DayOfWeek;

public record DoctorSearch(
		String department,
		String name,
		String degree,
		DayOfWeek day
		) {

}
