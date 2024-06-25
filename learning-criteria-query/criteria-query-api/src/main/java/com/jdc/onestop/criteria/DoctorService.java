package com.jdc.onestop.criteria;

import java.util.List;

import com.jdc.onestop.criteria.input.DoctorSearch;
import com.jdc.onestop.criteria.output.DoctorDetailsInfo;
import com.jdc.onestop.criteria.output.DoctorListItem;

public interface DoctorService {

	List<DoctorListItem> search(DoctorSearch form);
	DoctorDetailsInfo findById(int id);
}
