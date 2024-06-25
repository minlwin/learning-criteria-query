package com.jdc.onestop.criteria;

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
		// TODO Auto-generated method stub
		return null;
	}

}
