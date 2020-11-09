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
 * Servlet implementation class ProductControlServlet
 */
@WebServlet("/ProductControlServlet")
public class ProductControlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
		
			PartnerService pservice=new PartnerService();
			LeportsDTO ldto=pservice.reservationControl("L9");
			System.out.println(ldto);
			
			session.setAttribute("reserve", ldto);
			
			RequestDispatcher dis=request.getRequestDispatcher("");
			dis.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
