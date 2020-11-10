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
 * Servlet implementation class PartnerMypageUpdate
 */
@WebServlet("/PartnerMypageUpdate")
public class PartnerMypageUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
		
			
			
		String partner_id=request.getParameter("partner_id");  //null
		String user_id=request.getParameter("user_id");
		String c_name=request.getParameter("c_name");
		String c_phone=request.getParameter("c_phone");
		String c_postnum=request.getParameter("c_postnum");
		String c_address=request.getParameter("c_address");
		String c_detail_address=request.getParameter("c_detail_address");
		String partner_license_num=request.getParameter("partner_license_num");
		String partner_license_docs=request.getParameter("partner_license_docs");
		
		PartnerDTO pdto=new PartnerDTO(partner_id,user_id,c_name,c_postnum,c_address,
				c_detail_address,c_phone,partner_license_num,partner_license_docs);
		System.out.println(pdto);
		PartnerService pservice=new PartnerService();
		int n=pservice.partnerUpdate(pdto);
		
		
		
		RequestDispatcher dis=request.getRequestDispatcher("partnermain.jsp");
		dis.forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
