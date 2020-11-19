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
import com.service.PartnerService;

/**
 * Servlet implementation class ProductAddItemServlet
 */
@WebServlet("/ProductAddItemServlet")
public class ProductAddItemServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			PartnerService pservice=new PartnerService();
			
			String leports_summary=request.getParameter("leports_summary");
			String leports_price=request.getParameter("leports_price");
			String leports_max_capacity=request.getParameter("leports_max_capacity");	
			String leports_item_title=request.getParameter("leports_item_title");
			String leports_id=request.getParameter("leports_id");
			
			
			LeportsItemDTO idto=new LeportsItemDTO(leports_id,leports_item_title,leports_summary,
					leports_price,leports_max_capacity);
			

			pservice.leportsItemInsert(idto);
			System.out.println(idto);
			
			session.setAttribute("leports_item", idto);
			session.setAttribute("productAddMesg", "상품 등록이 완료 되었습니다.");
			
			RequestDispatcher dis=request.getRequestDispatcher("MainPartner.jsp");
			dis.forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
