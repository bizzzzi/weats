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
 * Servlet implementation class ProductDetailSelectServlet
 */
@WebServlet("/ProductDetailSelectServlet")
public class ProductDetailSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			String leports_id=(String)request.getParameter("leports_id");
			
			PartnerService pservice=new PartnerService();
			LeportsDTO ldto= pservice.ProductDetailLeports(leports_id);
			LeportsItemDTO idto=pservice.ProductDetailItem(leports_id);
			
			session.setAttribute("leports", ldto);
			session.setAttribute("item", idto);
			
			RequestDispatcher dis=request.getRequestDispatcher("partner/productDetailControl.jsp");
			dis.forward(request, response);
		
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
