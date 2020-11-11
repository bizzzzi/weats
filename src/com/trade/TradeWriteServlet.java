package com.trade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TradeDTO;
import com.service.TradeService;

/**
 * Servlet implementation class TradeWriteServlet
 */
@WebServlet("/TradeWriteServlet")
public class TradeWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String trade_id = request.getParameter("trade_id");
		String user_id = request.getParameter("user_id");
		String trade_main_img = request.getParameter("trade_main_img");
		String trade_sub_img1 = request.getParameter("trade_sub_img1");
		String trade_sub_img2 = request.getParameter("trade_sub_img2");
		String trade_sub_img3 = request.getParameter("trade_sub_img3");
		String trade_sub_img4 = request.getParameter("trade_sub_img4");
		String trade_title = request.getParameter("trade_title");
		String trade_contents = request.getParameter("trade_contents");
		String trade_type = request.getParameter("trade_type");
		String trade_loc = request.getParameter("trade_loc");
		String trade_phone = request.getParameter("trade_phone");
		String trade_user_name = request.getParameter("trade_user_name");
		int trade_price = Integer.parseInt(request.getParameter("trade_price"));
		String trade_regidate = request.getParameter("trade_regidate");
		int trade_hit = 1;

		TradeService service = new TradeService();
		TradeDTO dto = new TradeDTO(trade_id,user_id,trade_main_img,trade_sub_img1,trade_sub_img2,trade_sub_img3,trade_sub_img4,trade_title,trade_contents,trade_type,trade_loc,trade_phone,trade_user_name,trade_price,trade_regidate,trade_hit);
		int num=0;
		
		num=service.tradeWrite(dto);
		if(num!=0) {
			System.out.println("insert 성공");
			response.sendRedirect("TradeListServlet");
		}else {
			System.out.println("insert 실패");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
