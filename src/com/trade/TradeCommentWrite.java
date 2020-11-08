package com.trade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TradeCommentsDTO;
import com.service.TradeService;

/**
 * Servlet implementation class TradeCommentWrite
 */
@WebServlet("/TradeCommentWrite")
public class TradeCommentWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradeService service=new TradeService();
		TradeCommentsDTO dto=null;
		String trade_id=request.getParameter("trade_id");
		String user_id=request.getParameter("user_id");
		String trade_comment=request.getParameter("trade_comment");
		int num=0;
		String nextPage=null;
		System.out.println("comment데이터 파싱:"+trade_id+"\t"+user_id+"\t"+trade_comment);
		if(trade_id!=null) {
			dto=new TradeCommentsDTO(null,trade_id,user_id,trade_comment,null);
			num=service.CommentWrite(dto);
			System.out.println("comment insert: "+num);
		}
		response.sendRedirect("TradeDetailServlet?trade_id="+trade_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
