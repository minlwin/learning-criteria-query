package com.jdc.onestop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.embeddable.Contact_;
import com.jdc.onestop.criteria.entity.Patient;
import com.jdc.onestop.criteria.entity.Patient_;
import com.jdc.onestop.criteria.input.PatientSearch;
import com.jdc.onestop.criteria.output.PatientListItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class PatientServiceImpl extends AbstractService implements PatientService{

	public PatientServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<PatientListItem> search(PatientSearch form) {
		try(var em = emSupplier.get()) {
			
			var cb = em.getCriteriaBuilder();
			var cq = cb.createQuery(PatientListItem.class);
			
			var root = cq.from(Patient.class);
			
			cq.multiselect(
				root.get(Patient_.id),
				root.get(Patient_.name),
				root.get(Patient_.contact).get(Contact_.phone),
				root.get(Patient_.contact).get(Contact_.email),
				root.get(Patient_.gender),
				root.get(Patient_.dob),
				root.get(Patient_.registAt)
			);
			
			var params = new ArrayList<Predicate>();
			
			if(!isBlank(form.name())) {
				params.add(cb.like(cb.lower(root.get(Patient_.name)), form.name().toLowerCase().concat("%")));
			}
			
			if(!isBlank(form.phone())) {
				params.add(cb.like(cb.lower(root.get(Patient_.contact).get(Contact_.phone)), form.phone().toLowerCase().concat("%")));
			}
			
			if(null != form.from()) {
				params.add(cb.greaterThanOrEqualTo(root.get(Patient_.registAt), form.from().atStartOfDay()));
			}
			
			if(null != form.to()) {
				params.add(cb.lessThan(root.get(Patient_.registAt), form.to().plusDays(1).atStartOfDay()));
			}
			
			cq.where(params.toArray(size -> new Predicate[size]));
			cq.orderBy(cb.asc(root.get(Patient_.id)));
			
			return em.createQuery(cq).getResultList();
		}
	}

}
