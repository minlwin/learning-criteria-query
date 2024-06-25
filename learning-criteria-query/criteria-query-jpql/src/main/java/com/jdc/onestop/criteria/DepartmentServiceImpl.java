package com.jdc.onestop.criteria;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.input.DepartmentSearch;
import com.jdc.onestop.criteria.output.DepartmentListItem;

import jakarta.persistence.EntityManager;

public class DepartmentServiceImpl extends AbstractService implements DepartmentService{

	public DepartmentServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<DepartmentListItem> search(DepartmentSearch form) {
		
		try(var em = emSupplier.get()) {
			// select new com.jdc.onestop.criteria.output.DepartmentListItem(dp.code, dp.nane, dp.phone, dp.email, count(dc.id)) from Department dp 
			// left join dp.doctor dc where 1 = 1 
			// group by dp.code, dp.nane, dp.phone, dp.email
			
			var params = new HashMap<String, Object>();
			var sb = new StringBuffer();
			sb.append("select new com.jdc.onestop.criteria.output.DepartmentListItem(dp.code, dp.name, dp.contact.phone, dp.contact.email, count(dc.id)) from Department dp left join dp.doctor dc where 1 = 1");
			
			if(!isBlank(form.code())) {
				sb.append(" and dp.code = :code");
				params.put("code", form.code());
			}
			
			if(!isBlank(form.name())) {
				sb.append(" and lower(dp.name) like :name");
				params.put("name", form.name().toLowerCase().concat("%"));
			}
			
			if(!isBlank(form.phone())) {
				sb.append(" and lower(dp.contact.phone) like :phone");
				params.put("phone", form.phone().toLowerCase().concat("%"));
			}
			
			sb.append(" group by dp.code, dp.name, dp.contact.phone, dp.contact.email");
			
			var query = em.createQuery(sb.toString(), DepartmentListItem.class);
			
			for(var param : params.keySet()) {
				query.setParameter(param, params.get(param));
			}
			
			return query.getResultList();
		}
		
	}

}
