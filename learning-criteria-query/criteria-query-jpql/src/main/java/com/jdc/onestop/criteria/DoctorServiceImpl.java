package com.jdc.onestop.criteria;

import java.util.HashMap;
import java.util.List;
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
		
		try(var em = emSupplier.get()) {
			
			var params = new HashMap<String, Object>();
			var sb = new StringBuffer();
			
			sb.append("select new com.jdc.onestop.criteria.output.DoctorListItem(dt.id, dt.name, dt.contact.phone, dt.contact.email, dt.gender, dt.degree) from Doctor dt left join dt.department dp left join dt.schedule s where 1 = 1");

			if(!isBlank(form.department())) {
				sb.append(" and dp.code = :code");
				params.put("code", form.department());
			}
			
			if(!isBlank(form.name())) {
				sb.append(" and lower(dt.name) like :name");
				params.put("name", form.name().toLowerCase().concat("%"));
			}
			
			if(!isBlank(form.degree())) {
				sb.append(" and lower(dt.degree) = :degree");
				params.put("degree", form.degree());
			}
			
			if(null != form.day()) {
				sb.append(" and s.dayOfWeek = :day");
				params.put("day", form.day());
			}
			
			sb.append(" group by dt.id, dt.name, dt.contact.phone, dt.contact.email, dt.gender, dt.degree");
			sb.append(" order by dt.id");
			
			var query = em.createQuery(sb.toString(), DoctorListItem.class);
			for(var param : params.keySet()) {
				query.setParameter(param, params.get(param));
			}
			
			return query.getResultList();
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
