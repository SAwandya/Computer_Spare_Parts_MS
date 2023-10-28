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

@WebServlet("/deleteItemServlet")
public class deleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String id = request.getParameter("itemId");
		
		//convert id to integer
		
		int convertedId = Integer.parseInt(id);
		
		try {
			
			boolean isTrue;
			
			SparePartsService obj1 = new SparePartImple();
			
			 isTrue = obj1.deleteItems(convertedId);
			 
			 if(isTrue == true) {			 			
				 
				 response.sendRedirect(request.getContextPath() + "/Landing");
				 
			 }else {
				 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
				 dis.forward(request, response);
			 }
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
