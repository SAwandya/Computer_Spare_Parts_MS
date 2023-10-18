package com.shopmanager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ShopManagerLogoutServlet")
public class ShopManagerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String logout = request.getParameter("log");
		
		if("logout".equals(logout)) {
			
			HttpSession session = request.getSession();

			session.removeAttribute("mgr");
			
			RequestDispatcher dis = request.getRequestDispatcher("shopManagerLogin.jsp");
			dis.forward(request, response);
		}
	}

}
