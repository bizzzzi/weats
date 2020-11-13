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
 * Servlet implementation class ProductDetailControlServlet
 */
@WebServlet("/ProductDetailControlServlet")
public class ProductDetailControlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String leports_id=request.getParameter("leports_id");
		PartnerService pservice=new PartnerService();
		LeportsDTO ldto=pservice.reservationControl(leports_id);
		
		session.setAttribute("leports", ldto);
		
		RequestDispatcher dis=request.getRequestDispatcher("partner/productDetailControl.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
