package com.arvind.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.arvind.entity.CitizenPlan;
import com.arvind.repository.CitizenPlanRepository;
import com.arvind.request.SearchRequest;
import com.arvind.util.EmailUtils;
import com.arvind.util.ExcelGenerator;
import com.arvind.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServiceReportsImp implements ServiceReports {
	
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
     @Autowired
	private EmailUtils emailUtils;
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
	public boolean exportPdf(HttpServletResponse res) throws Exception {
		File f =new File("plans.pdf");
		List<CitizenPlan> list = repo.findAll();
		pdfGenerator.generator(res, list,f);
		String subject="Test mail subject";
		String body="<h1>Test mail body</h1>";
		String to="arvindpal9941@gmail.com";
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse res) throws Exception {
		List<CitizenPlan> list = repo.findAll();
		File f =new File("plans.xls");
		excelGenerator.generator(res, list,f);
		String subject="Test mail subject";
		String body="<h1>Test mail body</h1>";
		String to="arvindpal9941@gmail.com";
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
