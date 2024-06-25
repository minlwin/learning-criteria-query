package com.jdc.onestop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.entity.Doctor;
import com.jdc.onestop.criteria.input.DoctorSearch;
import com.jdc.onestop.criteria.output.DoctorDetailsInfo;
import com.jdc.onestop.criteria.output.DoctorListItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class DoctorServiceImpl extends AbstractService implements DoctorService {

	public DoctorServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<DoctorListItem> search(DoctorSearch form) {
		try(var em = emSupplier.get()) {
			
			var cb = em.getCriteriaBuilder();
			var cq = cb.createQuery(DoctorListItem.class);
			
			var root = cq.from(Doctor.class);
			var department = root.join("department", JoinType.LEFT);
			var schedule = root.join("schedule", JoinType.LEFT);
			
			cq.multiselect(
				root.get("id"),
				root.get("name"),
				root.get("contact").get("phone"),
				root.get("contact").get("email"),
				root.get("gender"),
				root.get("degree")
			);
			
			var params = new ArrayList<Predicate>();
			
			if(!isBlank(form.department())) {
				params.add(cb.equal(department.get("code"), form.department()));
			}
			
			if(!isBlank(form.name())) {
				params.add(cb.like(cb.lower(root.get("name")), form.name().toLowerCase().concat("%")));
			}
			
			if(!isBlank(form.degree())) {
				params.add(cb.equal(root.get("degree"), form.degree().toLowerCase()));
			}
			
			if(null != form.day()) {
				params.add(cb.equal(schedule.get("dayOfWeek"), form.day()));
			}
			
			cq.where(params.toArray(size -> new Predicate[size]));
			
			cq.groupBy(
				root.get("id"),
				root.get("name"),
				root.get("contact").get("phone"),
				root.get("contact").get("email"),
				root.get("gender"),
				root.get("degree")
			);
			
			cq.orderBy(cb.asc(root.get("id")));
			
			return em.createQuery(cq).getResultList();
		} 
	}

	@Override
	public DoctorDetailsInfo findById(int id) {
		
		try(var em = emSupplier.get()) {
			
			var entity = em.find(Doctor.class, id);
			
			if(null != entity) {
				return DoctorDetailsInfo.from(entity);
			}
		}
		return null;
	}

}
