package com.partner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.PartnerDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class PartnerKeyCheckServlet
 */
@WebServlet("/PartnerKeyCheckServlet")
public class PartnerKeyCheckServlet extends HttpServlet {
	//로그인시 파트너 키 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			MemberDTO dto=(MemberDTO) session.getAttribute("login");
			int partner_key=dto.getPartner_verify();
			String user_id=dto.getUser_id();
			
			PartnerService pservice=new PartnerService();
			PartnerDTO pdto=pservice.partnerSelect(user_id);
			
			if(partner_key==1) {
				session.setAttribute("partner", pdto);
				System.out.println(pdto);
			}
			
			RequestDispatcher dis=request.getRequestDispatcher("main.jsp");
			dis.forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
