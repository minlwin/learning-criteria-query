package com.jdc.onestop.criteria;

import java.util.HashMap;
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
		try(var em = emSupplier.get()) {
			
			var params = new HashMap<String, Object>();
			var sb = new StringBuffer();
			
			sb.append("select new com.jdc.onestop.criteria.output.PatientListItem(p.id, p.name, p.contact.phone, p.contact.email, p.gender, p.dob, p.registAt) from Patient p where 1 = 1");
			
			if(!isBlank(form.name())) {
				sb.append(" and lower(p.name) like :name");
				params.put("name", form.name().toLowerCase().concat("%"));
			}
			
			if(!isBlank(form.phone())) {
				sb.append(" and lower(p.contact.phone) like :phone");
				params.put("phone", form.phone().toLowerCase().concat("%"));
			}
			
			if(null != form.from()) {
				sb.append(" and p.registAt >= :from");
				params.put("from", form.from().atStartOfDay());
			}
			
			if(null != form.to()) {
				sb.append(" and p.registAt < :to");
				params.put("to", form.to().plusDays(1).atStartOfDay());
			}
			
			var query = em.createQuery(sb.toString(), PatientListItem.class);
			for(var param : params.keySet()) {
				query.setParameter(param, params.get(param));
			}
			
			return query.getResultList();
		}
	}

}
