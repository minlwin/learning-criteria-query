package com.jdc.onestop.criteria.embeddable;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Schedule {

	@Column(nullable = false)
	private DayOfWeek dayOfWeek;
	@Column(nullable = false)
	private LocalTime startTime;
	@Column(nullable = false)
	private LocalTime endTime;
	@Column(nullable = false)
	private int maxPatient;
}
