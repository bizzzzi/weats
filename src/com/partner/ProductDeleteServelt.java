package com.partner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.PartnerService;

import oracle.net.aso.p;

/**
 * Servlet implementation class ProductDeleteServelt
 */
@WebServlet("/ProductDeleteServelt")
public class ProductDeleteServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String leports_id=request.getParameter("leports_id");
		PartnerService pservice=new PartnerService();
		
		pservice.leportsDelete(leports_id);
		
		RequestDispatcher dis=request.getRequestDispatcher("MainPartner.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
