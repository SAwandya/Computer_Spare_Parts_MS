package com.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.classes.Item;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.models.SparePartsService;
import com.models.SparePartImple;

@WebServlet("/PDFDownload")
public class PDFDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			SparePartsService obj1 = new SparePartImple();
			
			List<Item> items = obj1.getItemDetails();
			
			Document document = new Document();
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment; filename=database-data.pdf");
			
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();
			
			 Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
	            Paragraph title = new Paragraph("Database Data Report", titleFont);
	            title.setAlignment(Element.ALIGN_CENTER);
	            document.add(title);
	            
	            document.add(new Paragraph(" "));
	            
	        float[] columnWidths = {0.5f, 2f, 2f, 2f, 3f, 3f};
			
			PdfPTable table = new PdfPTable(columnWidths);
			table.setWidthPercentage(98);
			
			Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
			
			table.addCell(new PdfPCell(new Phrase("ID", headerFont)));
			table.addCell(new PdfPCell(new Phrase("Type", headerFont)));
			table.addCell(new PdfPCell(new Phrase("Brand", headerFont)));
			table.addCell(new PdfPCell(new Phrase("Unit Price", headerFont)));
			table.addCell(new PdfPCell(new Phrase("Purchase", headerFont)));
			table.addCell(new PdfPCell(new Phrase("Sold", headerFont)));
			
			double totalPurchasePrice = 0;
			double totalSoldPrice = 0;
			
			for(Item item : items) {
				
				totalPurchasePrice = totalPurchasePrice + (item.getUnitPrice() * item.getPurchase());
				totalSoldPrice = totalSoldPrice + (item.getUnitPrice() * item.getSold());
				
				table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getItemId()))));
				table.addCell(new PdfPCell(new Phrase(item.gettype())));
				table.addCell(new PdfPCell(new Phrase(item.getBrandName())));
				table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getUnitPrice())+ "LKR")));
				table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getPurchase()))));
				table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getSold()))));
			}
			
			table.addCell(new PdfPCell(new Phrase()));
			table.addCell(new PdfPCell(new Phrase()));
			table.addCell(new PdfPCell(new Phrase()));
			table.addCell(new PdfPCell(new Phrase("Total", headerFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(totalPurchasePrice) + "LKR")));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(totalSoldPrice) + "LKR")));
			
			document.add(table);
			
			document.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			response.getWriter().write("An error occurred while generate the PDF.");
		}
		
		response.sendRedirect(request.getContextPath() + "/Landing");
	}

}
