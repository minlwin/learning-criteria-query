package com.jdc.onestop.criteria;

import java.util.List;

import com.jdc.onestop.criteria.input.PatientSearch;
import com.jdc.onestop.criteria.output.PatientListItem;

public interface PatientService {

	List<PatientListItem> search(PatientSearch form);
}
