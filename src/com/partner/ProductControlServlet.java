package com.partner;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LeportsDTO;
import com.dto.MemberDTO;
import com.dto.PartnerDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class ProductControlServlet
 */
@WebServlet("/ProductControlServlet")
public class ProductControlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
		
			PartnerService pservice=new PartnerService();
			
			PartnerDTO pdto=(PartnerDTO)session.getAttribute("partner");
			String partner_id=pdto.getPartner_id();
			
			List<LeportsDTO> list=pservice.ProductControl(partner_id);
			System.out.println(list);
			
			session.setAttribute("leports_list", list);
			
			RequestDispatcher dis=request.getRequestDispatcher("partner/ProductControl.jsp");
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
