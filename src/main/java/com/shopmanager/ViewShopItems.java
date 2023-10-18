package com.shopmanager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/Landing")
public class ViewShopItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemDetails = request.getParameter("search");
		
		if(itemDetails == null) {
			
			List<Item> ItemDetails = ShopManagerDBUtil.getItemDetails();
			 
			 request.setAttribute("ItemDetails", ItemDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("shopManagerDashboard.jsp");
			 dis.forward(request, response);
		}else {
			
			List<Item> ItemDetails = ShopManagerDBUtil.searchItem(itemDetails);
			 
			 request.setAttribute("ItemDetails", ItemDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("shopManagerDashboard.jsp");
			 dis.forward(request, response);
		}
		
		
	}

}
