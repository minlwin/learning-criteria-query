package com.jdc.onestop.criteria;

import java.util.List;

import com.jdc.onestop.criteria.input.DepartmentSearch;
import com.jdc.onestop.criteria.output.DepartmentListItem;

public interface DepartmentService {

	List<DepartmentListItem> search(DepartmentSearch form);
}
