package com.jdc.onestop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.embeddable.Contact_;
import com.jdc.onestop.criteria.embeddable.Schedule_;
import com.jdc.onestop.criteria.entity.Department_;
import com.jdc.onestop.criteria.entity.Doctor;
import com.jdc.onestop.criteria.entity.Doctor_;
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
			var department = root.join(Doctor_.department, JoinType.LEFT);
			var schedule = root.join(Doctor_.schedule, JoinType.LEFT);
			
			cq.multiselect(
				root.get(Doctor_.id),
				root.get(Doctor_.name),
				root.get(Doctor_.contact).get(Contact_.phone),
				root.get(Doctor_.contact).get(Contact_.email),
				root.get(Doctor_.gender),
				root.get(Doctor_.degree)
			);
			
			var params = new ArrayList<Predicate>();
			
			if(!isBlank(form.department())) {
				params.add(cb.equal(department.get(Department_.code), form.department()));
			}
			
			if(!isBlank(form.name())) {
				params.add(cb.like(cb.lower(root.get(Doctor_.name)), form.name().toLowerCase().concat("%")));
			}
			
			if(!isBlank(form.degree())) {
				params.add(cb.equal(root.get(Doctor_.degree), form.degree().toLowerCase()));
			}
			
			if(null != form.day()) {
				params.add(cb.equal(schedule.get(Schedule_.dayOfWeek), form.day()));
			}
			
			cq.where(params.toArray(size -> new Predicate[size]));
			
			cq.groupBy(
				root.get(Doctor_.id),
				root.get(Doctor_.name),
				root.get(Doctor_.contact).get(Contact_.phone),
				root.get(Doctor_.contact).get(Contact_.email),
				root.get(Doctor_.gender),
				root.get(Doctor_.degree)
			);
			
			cq.orderBy(cb.asc(root.get("id")));
			
			return em.createQuery(cq).getResultList();
		} 
	}

	@Override
	public DoctorDetailsInfo findById(int id) {
		
		try(var em = emSupplier.get()) {
			return Optional.ofNullable(em.find(Doctor.class, id))
					.map(DoctorDetailsInfo::from).orElse(null);
		}
		
	}


}
