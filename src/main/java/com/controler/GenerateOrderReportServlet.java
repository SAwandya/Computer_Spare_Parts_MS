package com.controler;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.ShopManagerDBUtil;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.classes.Item;
import com.itextpdf.text.BaseColor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GenerateOrderReportServlet")
public class GenerateOrderReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> orders = ShopManagerDBUtil.getItemDetails();
        
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {         
            
            PdfWriter.getInstance(document, baos);
            document.open();

            // Add a title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph("Order Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add a table with order details
            PdfPTable table = new PdfPTable(4); // 4 columns
            table.setWidthPercentage(100);
            
            Font cellFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            
            // Add table headers
            addTableHeader(table, cellFont);

            // Add order details
            addTableData(table, orders, cellFont);

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=order_report.pdf");


        OutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.close();
    }




    private void addTableHeader(PdfPTable table, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPhrase(new Phrase("Order ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Priority", font));
        table.addCell(cell);
    }

    private void addTableData(PdfPTable table, List<Item> orders, Font font) {
        for (Item order : orders) {
            table.addCell(new Phrase(String.valueOf(order.getItemId()), font));
            table.addCell(new Phrase(order.getLocation(), font));
            table.addCell(new Phrase(String.valueOf(order.getAmount()), font));
            table.addCell(new Phrase(String.valueOf(order.getAmount()), font));
        }
    }
}