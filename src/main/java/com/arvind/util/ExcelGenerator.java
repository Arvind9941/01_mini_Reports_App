package com.arvind.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.arvind.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public void generator(HttpServletResponse res,List<CitizenPlan> records,File f) throws Exception {
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet=workbook.createSheet();
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amt");
		 
		int dataIndex=1;
		
		for(CitizenPlan p:records) {
			Row dataRow = sheet.createRow(dataIndex);
			dataRow.createCell(0).setCellValue(p.getCitizenId());
			dataRow.createCell(1).setCellValue(p.getCitizenName());
			dataRow.createCell(2).setCellValue(p.getPlanName());
			dataRow.createCell(3).setCellValue(p.getPlanStatus());
			dataRow.createCell(4).setCellValue(p.getPlanStartDate()+"");
			dataRow.createCell(5).setCellValue(p.getPlanEndDate()+"");
			if(p.getBenefitAmt()!=null) {
				dataRow.createCell(6).setCellValue(p.getBenefitAmt());
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataIndex++;
		}
	
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		ServletOutputStream sos=res.getOutputStream();
		workbook.write(sos);
		workbook.close();
	}
}
