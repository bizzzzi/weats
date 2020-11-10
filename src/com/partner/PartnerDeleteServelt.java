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

/**
 * Servlet implementation class PartnerDeleteServelt
 */
@WebServlet("/PartnerDeleteServelt")
public class PartnerDeleteServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			String partner_id=request.getParameter("partner_id");
		
			PartnerService pservice=new PartnerService();
			pservice.partnerDelete(partner_id);
			
			session.setAttribute("partnerDeleteMesg", "파트너 탈퇴가 완료되었습니다");
			RequestDispatcher dis=request.getRequestDispatcher("main.jsp");
			dis.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
