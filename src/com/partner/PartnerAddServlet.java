package com.partner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.PartnerDTO;
import com.service.MemberService;
import com.service.PartnerService;

/**
 * Servlet implementation class PartnerAddServlet
 */
@WebServlet("/PartnerAddServlet")
public class PartnerAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String c_name=request.getParameter("c_name");
			String c_phone=request.getParameter("c_phone");
			String c_postnum=request.getParameter("c_postnum");
			String c_address=request.getParameter("c_address");
			String c_detail_address=request.getParameter("c_detail_address");
			String partner_license_num=request.getParameter("partner_license_num");
			String partner_license_docs=request.getParameter("partner_license_docs");
			
			HttpSession session=request.getSession();
			PartnerService pservice=new PartnerService();
//			String user_email = (String)session.getAttribute("user_email");
//			MemberService mservice= new MemberService();
//			String user_id=mservice.selectUserid(user_email);
//			System.out.println(user_id);
			
			//user_email로 user_id 값 가져오기
//			String user_email=(String)session.getAttribute("user_email");
//			String user_id=pservice.selectUserid(user_email);
//			System.out.println(user_id);
			
			
//			
//			System.out.println(c_name+"\t"+partner_license_docs);
			PartnerDTO pdto=new PartnerDTO(null,"M3",c_name,c_postnum,c_address,
					c_detail_address,c_phone,partner_license_num,partner_license_docs);
			System.out.println(pdto);
		
			int n=pservice.partnerInsert(pdto);
			System.out.println(n);
			
			
			session.setAttribute("partner",pdto);
			response.sendRedirect("main.jsp");
			
			
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
