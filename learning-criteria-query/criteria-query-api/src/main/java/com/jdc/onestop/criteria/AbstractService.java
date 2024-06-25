package com.jdc.onestop.criteria;

import java.util.function.Supplier;

import jakarta.persistence.EntityManager;

public abstract class AbstractService {

	protected Supplier<EntityManager> emSupplier;

	public AbstractService(Supplier<EntityManager> emSupplier) {
		super();
		this.emSupplier = emSupplier;
	}

	protected boolean isBlank(String value) {
		return null == value || value.isBlank();
	}
}
