package com.jdc.onestop.criteria;

public class HospitalBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HospitalBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public HospitalBusinessException(String message) {
		super(message);
	}

}
