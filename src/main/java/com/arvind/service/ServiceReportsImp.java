package com.arvind.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.arvind.entity.CitizenPlan;
import com.arvind.repository.CitizenPlanRepository;
import com.arvind.request.SearchRequest;

@Service
public class ServiceReportsImp implements ServiceReports {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatuses() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity=new CitizenPlan();
		if(request.getPlanName()!=null && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(request.getPlanStatus()!=null && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(request.getGender()!=null && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(request.getStartDate()!=null && !"".equals(request.getStartDate())) {
			String startDate=request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//converting string to localdate
			LocalDate date = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(date);
		}
		if(request.getEndDate()!=null && !"".equals(request.getEndDate())) {
			String endDate=request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//converting string to localdate
			LocalDate date = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(date);
		}
		
		return repo.findAll(Example.of(entity)); 
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
