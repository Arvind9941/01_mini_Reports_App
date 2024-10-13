package com.arvind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arvind.request.SearchRequest;
import com.arvind.service.ServiceReportsImp;


@Controller
public class ReportController {
	
	@Autowired					
	private ServiceReportsImp service;
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search,Model m) {
		m.addAttribute("plans", service.search(search));
		init(m);
		return "index";
	}
	
	@GetMapping("/")
	public String indexPage(Model m) {
		m.addAttribute("search", new SearchRequest());
		init(m);
		return "index";
	}

	private void init(Model m) {
		m.addAttribute("plan", service.getPlanNames());
		m.addAttribute("status", service.getPlanStatuses());
	}

}
