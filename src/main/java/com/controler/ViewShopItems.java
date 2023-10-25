package com.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.classes.Item;
import com.models.ShopManagerDBUtil;

import com.models.SparePartsService;
import com.models.SparePartImple;

@WebServlet("/Landing")
public class ViewShopItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemDetails = request.getParameter("search");
		
		SparePartsService obj1 = new SparePartImple();
		
		if(itemDetails == null) {			
			
			List<Item> ItemDetails = obj1.getItemDetails();
			 
			 request.setAttribute("ItemDetails", ItemDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("shopManagerDashboard.jsp");
			 dis.forward(request, response);
		}else {
			
			List<Item> ItemDetails = obj1.searchItem(itemDetails);
			 
			 request.setAttribute("ItemDetails", ItemDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("shopManagerDashboard.jsp");
			 dis.forward(request, response);
		}
		
		
	}

}
