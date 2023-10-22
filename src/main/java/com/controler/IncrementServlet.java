package com.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.models.ShopManagerDBUtil;

@WebServlet("/IncrementServlet")
public class IncrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String id = request.getParameter("increment");
		int convertedId = Integer.parseInt(id);
		
		boolean isTrue;
		 
		 isTrue = ShopManagerDBUtil.incrementAmount(convertedId);
		 
		 if(isTrue == true) {			 			
			 
			 response.sendRedirect(request.getContextPath() + "/Landing");
			 
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
	}

}