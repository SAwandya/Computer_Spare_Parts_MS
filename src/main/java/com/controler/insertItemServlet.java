package com.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.models.ShopManagerDBUtil;

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
		
		boolean isTrue;
		 
		 isTrue = ShopManagerDBUtil.insertItems(brand, location, wid, shopId, shopMgrId, type, convertedUnitPrice, convertedAmount);
		 
		 if(isTrue == true) {			 			
			 
			 response.sendRedirect(request.getContextPath() + "/Landing");
			 
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
		
	}

}
