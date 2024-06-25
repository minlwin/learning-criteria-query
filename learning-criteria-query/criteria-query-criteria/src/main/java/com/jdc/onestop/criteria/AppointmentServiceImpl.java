package com.jdc.onestop.criteria;

import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.input.AppointmentDetailsInfo;
import com.jdc.onestop.criteria.input.AppointmentEditForm;
import com.jdc.onestop.criteria.input.AppointmentSearch;
import com.jdc.onestop.criteria.output.AppointmentListItem;

import jakarta.persistence.EntityManager;

public class AppointmentServiceImpl extends AbstractService implements AppointmentService {

	public AppointmentServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public AppointmentDetailsInfo create(AppointmentEditForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentListItem> search(AppointmentSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

}
