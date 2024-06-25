package com.jdc.onestop.criteria.output;

import com.jdc.onestop.criteria.enums.Gender;

public record DoctorListItem(
		int id,
		String name,
		String phone,
		String email,
		Gender gender,
		String degree,
		String departmentCode,
		String departmentName) {

}
