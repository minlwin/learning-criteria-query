package com.jdc.onestop.criteria;

import java.util.List;

import com.jdc.onestop.criteria.input.AppointmentEditForm;
import com.jdc.onestop.criteria.input.AppointmentSearch;
import com.jdc.onestop.criteria.output.AppointmentDetailsInfo;
import com.jdc.onestop.criteria.output.AppointmentListItem;

public interface AppointmentService {

	AppointmentDetailsInfo create(AppointmentEditForm form);
	
	List<AppointmentListItem> search(AppointmentSearch search);
}
