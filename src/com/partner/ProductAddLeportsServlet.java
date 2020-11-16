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
import com.dto.LeportsItemDTO;
import com.dto.PartnerDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class ProductAddServlet
 */
@WebServlet("/ProductAddLeportsServlet")
public class ProductAddLeportsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
			String leports_title=request.getParameter("leports_title");
			String leports_content=request.getParameter("leports_content");
			String leports_main_img=request.getParameter("leports_main_img");
			String leports_sub_img1=request.getParameter("leports_sub_img1");
			String leports_sub_img2=request.getParameter("leports_sub_img2");
			String leports_sub_img3=request.getParameter("leports_sub_img3");
			String leports_sub_img4=request.getParameter("leports_sub_img4");
			String leports_loc=request.getParameter("leports_loc");
			String leports_type=request.getParameter("leports_type");
			String leports_regidate=request.getParameter("leports_regidate");
					
			PartnerService pservice=new PartnerService();
			PartnerDTO pdto=(PartnerDTO) session.getAttribute("partner");
			String partner_id=pdto.getPartner_id();
			 
			LeportsDTO ldto=new LeportsDTO(null,partner_id,leports_title,leports_type,
					leports_loc,leports_regidate,leports_main_img,leports_sub_img1,
					leports_sub_img2,leports_sub_img3,leports_sub_img4,leports_content);
	
			System.out.println(ldto); //leports
		
			int n=pservice.leportsInsert(ldto);		
			
			
			RequestDispatcher dis=request.getRequestDispatcher("ProductLeportsIdServlet");
			dis.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
