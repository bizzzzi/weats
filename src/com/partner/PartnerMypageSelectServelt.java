package com.partner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.PartnerDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class PartnerMypageSelectServelt
 */
@WebServlet("/PartnerMypageSelectServelt")
public class PartnerMypageSelectServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			
			
			PartnerService pservice=new PartnerService();
			PartnerDTO pdto=pservice.partnerMypageSelect("P5");
			System.out.println(pdto);
			session.setAttribute("partnerSelect", pdto);
			RequestDispatcher dis=request.getRequestDispatcher("main.jsp");
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
