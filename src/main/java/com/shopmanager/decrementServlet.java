package com.shopmanager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DecrementServlet")
public class decrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("decrement");
		int convertedId = Integer.parseInt(id);
		
		boolean isTrue;
		 
		 isTrue = ShopManagerDBUtil.decrementAmount(convertedId);
		 
		 if(isTrue == true) {			 			
			 
			 response.sendRedirect(request.getContextPath() + "/Landing");
			 
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
	}

}