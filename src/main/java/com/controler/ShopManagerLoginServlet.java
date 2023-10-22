package com.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.classes.ShopManager;
import com.models.ShopManagerDBUtil;

@WebServlet("/ShopManagerLoginServlet")
public class ShopManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMessage = "";
		
		List<ShopManager> mgr = ShopManagerDBUtil.validateShopManager(username, password);
		
		if(mgr != null && !mgr.isEmpty()) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("mgr", mgr);
			
			response.sendRedirect(request.getContextPath() + "/Landing");
		}else {
			
			errorMessage += "username or password incorrect!!<br>";
			request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("shopManagerLogin.jsp").forward(request, response);
		    return;
		}
	}

}
