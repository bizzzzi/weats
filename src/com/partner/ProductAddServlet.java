package com.partner;

import java.io.IOException;
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
 * Servlet implementation class ProductAddServlet
 */
@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		//sub_img4,item_title
			String leports_title=request.getParameter("leports_title");
			String leports_summary=request.getParameter("leports_summary");
			String leports_content=request.getParameter("leports_content");
			String leports_main_img=request.getParameter("leports_main_img");
			String leports_sub_img1=request.getParameter("leports_sub_img1");
			String leports_sub_img2=request.getParameter("leports_sub_img2");
			String leports_sub_img3=request.getParameter("leports_sub_img3");
			String leports_sub_img4=request.getParameter("leports_sub_img3");
			String leports_loc=request.getParameter("leports_loc");
			String leports_type=request.getParameter("leports_type");
			String leports_price=request.getParameter("leports_price");
			String leports_max_capacity=request.getParameter("leports_max_capacity");
			
			String leports_regidate=request.getParameter("leports_regidate");
			String user_id=request.getParameter("user_id");
			String partner_id=request.getParameter("partner_id");
			 
			LeportsDTO ldto=new LeportsDTO(user_id,"P2",leports_title,leports_type,
					leports_loc,leports_regidate,leports_main_img,leports_sub_img1,
					leports_sub_img2,leports_sub_img3,leports_sub_img4,leports_content);
			
			LeportsItemDTO idto=new LeportsItemDTO("L2","itemtitle",leports_summary,
					leports_price,leports_max_capacity);
			
			
			System.out.println(ldto); //leports
			System.out.println(idto); //leprots_item
			
			PartnerService pservice=new PartnerService();
			
			pservice.leportsInsert(ldto);
			pservice.leportsItemInsert(idto);
			
			session.setAttribute("leports", ldto);
			session.setAttribute("leports_item", idto);
			
			response.sendRedirect("main.jsp");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
