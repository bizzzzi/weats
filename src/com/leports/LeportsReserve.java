package com.leports;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeportsReserve
 */
@WebServlet("/LeportsReserve")
public class LeportsReserve extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String main_img = request.getParameter("main_img");
		String leports_title = request.getParameter("leports_title");
		String totalPrice = request.getParameter("totalPrice"); 
		request.setAttribute("totalPrice",totalPrice);
		request.setAttribute("main_img",main_img);
		
		RequestDispatcher dis = request.getRequestDispatcher("payment/MainPayment.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
