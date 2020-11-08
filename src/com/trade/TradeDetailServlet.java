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
@WebServlet("/TradeDetailServlet")
public class TradeDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String trade_id=(String)request.getParameter("trade_id");
		TradeService service=new TradeService();
		
		System.out.println(trade_id);
		TradeDTO dto=service.selectItem(trade_id);
		
		request.setAttribute("dto", dto);
		System.out.println("detailServlet"+dto);
		RequestDispatcher dis=request.getRequestDispatcher("MainTradeDetail.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
