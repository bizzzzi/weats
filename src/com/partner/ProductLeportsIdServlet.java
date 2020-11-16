package com.partner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LeportsDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class ProductLeportsIdServlet
 */
@WebServlet("/ProductLeportsIdServlet")
public class ProductLeportsIdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			String leports_title=request.getParameter("leports_title");
			
			PartnerService pservice=new PartnerService();
			
			LeportsDTO ldto=pservice.leportsIdSelect(leports_title);
	

			
			session.setAttribute("leports", ldto);
			
			RequestDispatcher dis=request.getRequestDispatcher("partner/productRegistrationForm_item.jsp");
			dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
