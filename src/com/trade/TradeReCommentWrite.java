package com.trade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TradeCommentsDTO;
import com.dto.TradeReCommentsDTO;
import com.service.TradeService;

/**
 * Servlet implementation class TradeCommentWrite
 */
@WebServlet("/TradeReCommentWrite")
public class TradeReCommentWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("tradeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		TradeService service=new TradeService();
		TradeReCommentsDTO dto=null;
		String user_id=  request.getParameter("user_id");
		String trade_comment=request.getParameter("trade_comment");
		String trade_comment_id=request.getParameter("trade_comment_id");
		System.out.println("=========="+user_id);
		dto=new TradeReCommentsDTO(null,trade_comment_id,user_id,trade_comment,0,null);
		System.out.println(dto.getUser_id()+"\t"+dto.getTrade_comment()+"\t"+dto.getTrade_comment_id());
		int num=0;
		num=service.RecommentWrite(dto);
		System.out.println("recomment insert: "+"\t"+num);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
