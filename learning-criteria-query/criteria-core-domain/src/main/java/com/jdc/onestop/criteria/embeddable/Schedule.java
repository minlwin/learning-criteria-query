package com.jdc.onestop.criteria.embeddable;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Schedule {

	@Column(nullable = false, name = "day_of_week")
	private DayOfWeek dayOfWeek;
	@Column(nullable = false, name = "start_time")
	private LocalTime startTime;
	@Column(nullable = false, name = "end_time")
	private LocalTime endTime;
	@Column(nullable = false, name = "max_patient")
	private int maxPatient;
}
