package com.jdc.onestop.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.jdc.onestop.criteria.embeddable.Contact_;
import com.jdc.onestop.criteria.entity.Department;
import com.jdc.onestop.criteria.entity.Department_;
import com.jdc.onestop.criteria.entity.Doctor_;
import com.jdc.onestop.criteria.input.DepartmentSearch;
import com.jdc.onestop.criteria.output.DepartmentListItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class DepartmentServiceImpl extends AbstractService implements DepartmentService{

	public DepartmentServiceImpl(Supplier<EntityManager> emSupplier) {
		super(emSupplier);
	}

	@Override
	public List<DepartmentListItem> search(DepartmentSearch form) {
		
		try(var em = emSupplier.get()) {
			
			var cb = em.getCriteriaBuilder();
			var cq = cb.createQuery(DepartmentListItem.class);
			
			var root = cq.from(Department.class);
			var doctor = root.join(Department_.doctor, JoinType.LEFT);
			
			cq.multiselect(
				root.get(Department_.code),
				root.get(Department_.name),
				root.get(Department_.contact).get(Contact_.phone),
				root.get(Department_.contact).get(Contact_.email),
				cb.count(doctor.get(Doctor_.id))
			);
			
			var params = new ArrayList<Predicate>();
			
			if(!isBlank(form.code())) {
				params.add(cb.equal(root.get(Department_.code), form.code()));
			}
			
			if(!isBlank(form.name())) {
				params.add(cb.like(cb.lower(root.get(Department_.name)), form.name().toLowerCase().concat("%")));
			}
			
			if(!isBlank(form.phone())) {
				params.add(cb.like(cb.lower(root.get(Department_.contact).get(Contact_.phone)), form.phone().toLowerCase().concat("%")));
			}

			cq.where(params.toArray(size -> new Predicate[size]));
			
			cq.groupBy(				
				root.get(Department_.code),
				root.get(Department_.name),
				root.get(Department_.contact).get(Contact_.phone),
				root.get(Department_.contact).get(Contact_.email));
			
			cq.orderBy(cb.asc(root.get(Department_.code)));
			
			return em.createQuery(cq).getResultList();
		}
	}

}
