package com.jdc.onestop.criteria.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.onestop.criteria.entity.Appointment;
import com.jdc.onestop.criteria.enums.Gender;

public record AppointmentDetailsInfo(
		int doctorId, 
		String doctorName, 
		String doctorDegree, 
		int patientId,
		String patientName, 
		String patientPhone, 
		String patientEmail, 
		Gender patientGender, 
		LocalDate patientDob,
		LocalDate appointmentDate, 
		String startTime, 
		LocalDateTime registAt, 
		int seqNumber) {

	public static class Builder {

		private int doctorId;
		private String doctorName;
		private String doctorDegree;
		private int patientId;
		private String patientName;
		private String patientPhone;
		private String patientEmail;
		private Gender patientGender;
		private LocalDate patientDob;
		private LocalDate appointmentDate;
		private String startTime;
		private LocalDateTime registAt;
		private int seqNumber;

		public Builder doctorId(int doctorId) {
			this.doctorId = doctorId;
			return this;
		}

		public Builder doctorName(String doctorName) {
			this.doctorName = doctorName;
			return this;
		}

		public Builder doctorDegree(String doctorDegree) {
			this.doctorDegree = doctorDegree;
			return this;
		}

		public Builder patientId(int patientId) {
			this.patientId = patientId;
			return this;
		}

		public Builder patientName(String patientName) {
			this.patientName = patientName;
			return this;
		}

		public Builder patientPhone(String patientPhone) {
			this.patientPhone = patientPhone;
			return this;
		}

		public Builder patientEmail(String patientEmail) {
			this.patientEmail = patientEmail;
			return this;
		}

		public Builder patientGender(Gender patientGender) {
			this.patientGender = patientGender;
			return this;
		}

		public Builder patientDob(LocalDate patientDob) {
			this.patientDob = patientDob;
			return this;
		}

		public Builder appointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
			return this;
		}

		public Builder startTime(String startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder registAt(LocalDateTime registAt) {
			this.registAt = registAt;
			return this;
		}

		public Builder seqNumber(int seqNumber) {
			this.seqNumber = seqNumber;
			return this;
		}

		public AppointmentDetailsInfo build() {
			return new AppointmentDetailsInfo(doctorId, doctorName, doctorDegree, patientId, patientName, patientPhone,
					patientEmail, patientGender, patientDob, appointmentDate, startTime, registAt, seqNumber);
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static AppointmentDetailsInfo from(Appointment entity) {
		return builder()
				.doctorId(entity.getDoctor().getId())
				.doctorName(entity.getDoctor().getName())
				.doctorDegree(entity.getDoctor().getDegree())
				.patientId(entity.getPatient().getId())
				.patientName(entity.getPatient().getName())
				.patientDob(entity.getPatient().getDob())
				.patientEmail(entity.getPatient().getContact().getEmail())
				.patientPhone(entity.getPatient().getContact().getPhone())
				.patientGender(entity.getPatient().getGender())
				.appointmentDate(entity.getId().getAppointmentDate())
				.startTime(entity.getId().getStartTime())
				.seqNumber(entity.getSeqNumber())
				.build();
	}

}
