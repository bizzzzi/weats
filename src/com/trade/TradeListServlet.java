package com.trade;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.TradeDTO;
import com.service.TradeService;

/**
 * Servlet implementation class TradeListServlet
 */
@WebServlet("/TradeListServlet")
public class TradeListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=(String)request.getParameter("category");
		TradeService service=new TradeService();
		List<TradeDTO> list=null;
		if(category==null) {
			list=service.selectTrade("판매");
		}else {
			list=service.selectTrade(category);
		}
		
		String user_id=(String)request.getParameter("user_id");
		if(user_id!=null) {
			list=service.selectSelf(user_id);
		}

		request.setAttribute("list", list);

		RequestDispatcher dis=request.getRequestDispatcher("MainTrade.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
