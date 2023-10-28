package com.shopmanager.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.shopmanager.models.SparePartImple;
import com.shopmanager.models.SparePartsService;

@WebServlet("/updateItemServlet")
public class updateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorMessage = "";
		
		String itemId = request.getParameter("itemId");
		int convertedId = Integer.parseInt(itemId);
		
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		
		String unitprice = request.getParameter("unitprice");
		float convertedUnitPrice = Float.parseFloat(unitprice);
		
		try {
			
			if(convertedUnitPrice > 0) {
				
				boolean isTrue;
				
				SparePartsService obj1 = new SparePartImple();
				 
				 isTrue = obj1.updateItem(convertedId, type, brand, convertedUnitPrice);
				 
				 if(isTrue == true) {			 			
					 
					 response.sendRedirect(request.getContextPath() + "/Landing");
					 
				 }else {
					 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
					 dis.forward(request, response);
				 }
			}else {
				
				errorMessage += "Minues values cann't be enter to unit price!!<br>";
				request.setAttribute("errorMessage", errorMessage);
			    request.getRequestDispatcher("UpdateShopItems.jsp").forward(request, response);
			    return;
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
