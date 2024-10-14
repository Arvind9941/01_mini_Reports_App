package com.arvind.service;

import java.io.IOException;
import java.util.List;
import com.arvind.entity.CitizenPlan;
import com.arvind.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ServiceReports {
	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse res) throws Exception;
	public boolean exportPdf(HttpServletResponse res) throws Exception;

}
