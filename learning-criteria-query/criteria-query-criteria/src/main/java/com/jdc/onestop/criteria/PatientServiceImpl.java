package com.jdc.onestop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.entity.Patient;
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
				root.get("id"),
				root.get("name"),
				root.get("contact").get("phone"),
				root.get("contact").get("email"),
				root.get("gender"),
				root.get("dob"),
				root.get("registAt")
			);
			
			var params = new ArrayList<Predicate>();
			
			if(!isBlank(form.name())) {
				params.add(cb.like(cb.lower(root.get("name")), form.name().toLowerCase().concat("%")));
			}
			
			if(!isBlank(form.phone())) {
				params.add(cb.like(cb.lower(root.get("contact").get("phone")), form.phone().toLowerCase().concat("%")));
			}
			
			if(null != form.from()) {
				params.add(cb.greaterThanOrEqualTo(root.get("registAt"), form.from()));
			}
			
			if(null != form.to()) {
				params.add(cb.lessThan(root.get("registAt"), form.to().plusDays(1)));
			}
			
			cq.where(params.toArray(size -> new Predicate[size]));
			cq.orderBy(cb.asc(root.get("id")));
			
			return em.createQuery(cq).getResultList();
		}
		
	}

}
