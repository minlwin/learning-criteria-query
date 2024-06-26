package com.jdc.onestop.criteria.output;

import java.time.DayOfWeek;

import com.jdc.onestop.criteria.embeddable.Schedule;

public record DoctorSchedule(
		DayOfWeek day,
		String start,
		String end,
		int maxPatient) {

	public static DoctorSchedule from(Schedule entity) {
		return new DoctorSchedule(entity.getDayOfWeek(), entity.getStartTime(), entity.getEndTime(), entity.getMaxPatient());
	}
}
