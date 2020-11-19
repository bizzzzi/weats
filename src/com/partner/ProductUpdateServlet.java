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
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			String leports_title=request.getParameter("leports_title");
			String leports_content=request.getParameter("leports_content");
			String leports_price=request.getParameter("leports_price");
			String leports_summary=request.getParameter("leports_summary");
			String leports_max_capacity=request.getParameter("leports_max_capacity");
			String leports_item_title=request.getParameter("leports_item_title");
			String leports_main_img=request.getParameter("leports_main_img");
			String leports_sub_img1=request.getParameter("leports_sub_img1");
			String leports_sub_img2=request.getParameter("leports_sub_img2");
			String leports_sub_img3=request.getParameter("leports_sub_img3");
			String leports_sub_img4=request.getParameter("leports_sub_img4");
			String leports_type=request.getParameter("leports_type");
			String leports_loc=request.getParameter("leports_loc");
			String leports_id=request.getParameter("leports_id");
			
			PartnerService pservice=new PartnerService();
			
			LeportsDTO ldto=new LeportsDTO(leports_id,"",leports_title,
					leports_type,leports_loc,"",leports_main_img,leports_sub_img1,
					leports_sub_img2,leports_sub_img3,leports_sub_img4,leports_content);
			
			LeportsItemDTO idto=new LeportsItemDTO(leports_id,leports_item_title,
					leports_summary,leports_price,leports_max_capacity);
			
			pservice.ProductUpdateLeports(ldto);
			int n=pservice.ProductUpdateItem(idto);
			
			if(n==1) {
				session.setAttribute("leportsUpdateMesg", "수정이 완료되었습니다.");
			}
			
			RequestDispatcher dis=request.getRequestDispatcher("MainPartner.jsp");
			dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
