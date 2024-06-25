package com.jdc.onestop.criteria;

import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.input.PatientSearch;
import com.jdc.onestop.criteria.output.PatientListItem;

import jakarta.persistence.EntityManager;

public class PatientServiceImpl extends AbstractService implements PatientService{

	public PatientServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<PatientListItem> search(PatientSearch form) {
		// TODO Auto-generated method stub
		return null;
	}

}
