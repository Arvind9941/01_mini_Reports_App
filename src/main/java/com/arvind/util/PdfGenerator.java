package com.arvind.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arvind.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
@Component
public class PdfGenerator {
	public void generator(HttpServletResponse res,List<CitizenPlan> list,File f) throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, res.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		Paragraph p =new Paragraph();
		document.add(p);
		PdfPTable table =new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("plan Start Date");
		table.addCell("Plan End Date");

		for(CitizenPlan p1:list) {
			table.addCell(String.valueOf(p1.getCitizenId()));
			table.addCell(p1.getCitizenName());
			table.addCell(p1.getPlanName());
			table.addCell(p1.getPlanStatus());
			table.addCell(p1.getPlanStartDate()+"");
			table.addCell(p1.getPlanEndDate()+"");
		}
		
		document.add(table);
		document.close();
	}
}
