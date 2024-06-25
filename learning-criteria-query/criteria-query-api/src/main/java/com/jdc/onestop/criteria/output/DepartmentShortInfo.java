package com.jdc.onestop.criteria.output;

import com.jdc.onestop.criteria.entity.Department;

public record DepartmentShortInfo(
		String code,
		String name) {

	public static DepartmentShortInfo from(Department entity) {
		return new DepartmentShortInfo(entity.getCode(), entity.getName());
	}
}
