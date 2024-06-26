package com.jdc.onestop.criteria;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.entity.Doctor;
import com.jdc.onestop.criteria.input.DoctorSearch;
import com.jdc.onestop.criteria.output.DoctorDetailsInfo;
import com.jdc.onestop.criteria.output.DoctorListItem;

import jakarta.persistence.EntityManager;

public class DoctorServiceImpl extends AbstractService implements DoctorService {

	public DoctorServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<DoctorListItem> search(DoctorSearch form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDetailsInfo findById(int id) {
		
		try(var em = emSupplier.get()) {
			return Optional.ofNullable(em.find(Doctor.class, id))
					.map(DoctorDetailsInfo::from).orElse(null);
		}
		
	}


}
