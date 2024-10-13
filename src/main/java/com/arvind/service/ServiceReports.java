package com.arvind.service;

import java.util.List;

import com.arvind.entity.CitizenPlan;
import com.arvind.request.SearchRequest;

public interface ServiceReports {
	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel();
	public boolean exportPdf();

}
