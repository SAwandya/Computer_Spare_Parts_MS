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

@WebServlet("/insertItemServlet")
public class insertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		
		String unitprice = request.getParameter("unitprice");
		float convertedUnitPrice = Float.parseFloat(unitprice);
		
		String amount = request.getParameter("amount");
		int convertedAmount = Integer.parseInt(amount);
		
		String location = "shop";
		int wid = 1;
		int shopId = 2;
		int shopMgrId = 2;
		
		String errorMessage = "";
		
		try {
			
			if(convertedAmount > 0 && convertedUnitPrice > 0) {
				
				boolean isTrue;
				
				SparePartsService obj1 = new SparePartImple();
				 
				 isTrue = obj1.insertItems(brand, location, wid, shopId, shopMgrId, type, convertedUnitPrice, convertedAmount);
				 
				 if(isTrue == true) {			 			
					 
					 response.sendRedirect(request.getContextPath() + "/Landing");
					 
				 }else {
					 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
					 dis.forward(request, response);
				 }
				
			}else {
				
				
				errorMessage += "Minues values cann't be enter to unit price and amount<br>";
				request.setAttribute("errorMessage", errorMessage);
			    request.getRequestDispatcher("InsertItem.jsp").forward(request, response);
			    return;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
