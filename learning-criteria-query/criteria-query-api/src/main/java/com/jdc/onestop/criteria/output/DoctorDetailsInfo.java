package com.jdc.onestop.criteria.output;

import java.util.List;

import com.jdc.onestop.criteria.entity.Doctor;
import com.jdc.onestop.criteria.enums.Gender;

public record DoctorDetailsInfo(		
		int id,
		String name,
		String phone,
		String extraPhone,
		String email,
		Gender gender,
		String degree,
		List<DepartmentShortInfo> departments,
		List<DoctorSchedule> schedules) {

	public static DoctorDetailsInfo from(Doctor entity) {
		return builder()
				.id(entity.getId())
				.name(entity.getName())
				.phone(entity.getContact().getPhone())
				.extraPhone(entity.getContact().getExtraPhone())
				.email(entity.getContact().getEmail())
				.gender(entity.getGender())
				.degree(entity.getDegree())
				.departments(entity.getDepartment().stream().map(DepartmentShortInfo::from).toList())
				.schedules(entity.getSchedule().stream().map(DoctorSchedule::from).toList())
				.build();
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private int id;
		private String name;
		private String phone;
		private String extraPhone;
		private String email;
		private Gender gender;
		private String degree;
		private List<DepartmentShortInfo> departments;
		private List<DoctorSchedule> schedules;
		
		public DoctorDetailsInfo build() {
			return new DoctorDetailsInfo(id, name, phone, extraPhone, email, gender, degree, departments, schedules);
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder extraPhone(String extraPhone) {
			this.extraPhone = extraPhone;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Builder degree(String degree) {
			this.degree = degree;
			return this;
		}
		
		public Builder departments(List<DepartmentShortInfo> departments) {
			this.departments = departments;
			return this;
		}

		public Builder schedules(List<DoctorSchedule> schedules) {
			this.schedules = schedules;
			return this;
		}
	}
}
