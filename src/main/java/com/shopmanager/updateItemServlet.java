package com.shopmanager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateItemServlet")
public class updateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemId = request.getParameter("itemId");
		int convertedId = Integer.parseInt(itemId);
		
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		
		String unitprice = request.getParameter("unitprice");
		float convertedUnitPrice = Float.parseFloat(unitprice);
		
		String amount = request.getParameter("amount");
		int convertedAmount = Integer.parseInt(amount);
		
		boolean isTrue;
		 
		 isTrue = ShopManagerDBUtil.updateItem(convertedId, type, brand, convertedUnitPrice, convertedAmount);
		 
		 if(isTrue == true) {			 			
			 
			 response.sendRedirect(request.getContextPath() + "/Landing");
			 
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
		
		
	}

}
