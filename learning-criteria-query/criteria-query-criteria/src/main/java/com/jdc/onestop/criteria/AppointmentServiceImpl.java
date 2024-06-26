package com.jdc.onestop.criteria;

import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.input.AppointmentEditForm;
import com.jdc.onestop.criteria.input.AppointmentSearch;
import com.jdc.onestop.criteria.output.AppointmentDetailsInfo;
import com.jdc.onestop.criteria.output.AppointmentListItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AppointmentServiceImpl extends AbstractService implements AppointmentService {

	public AppointmentServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public AppointmentDetailsInfo create(AppointmentEditForm form) {
		
		EntityTransaction entityTransaction = null;
		
		try(var em = emSupplier.get()) {
			
			entityTransaction = em.getTransaction();
			entityTransaction.begin();
			
			
			entityTransaction.commit();
			return null;
		} catch (Throwable e) {
			
			if(null != entityTransaction) {
				entityTransaction.rollback();
			}
			
			return null;
		}
	}

	@Override
	public List<AppointmentListItem> search(AppointmentSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

}
