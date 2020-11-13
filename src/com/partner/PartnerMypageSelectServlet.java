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
 * Servlet implementation class PartnerMypageSelectServelt
 */
@WebServlet("/PartnerMypageSelectServlet")
public class PartnerMypageSelectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			MemberDTO dto=(MemberDTO)session.getAttribute("login");
			 String nextPage = null;
			 
			if(dto!=null) {			
				String user_id=dto.getUser_id();
				
				PartnerService pservice=new PartnerService();
				
				PartnerDTO pdto=pservice.partnerMypageSelect(user_id);
				System.out.println(pdto);
				session.setAttribute("partner", pdto);
						
				nextPage="partner/partnerMypage.jsp";
			}else {
				System.out.println("dto==null");
				nextPage="main.jsp";
			}
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
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
