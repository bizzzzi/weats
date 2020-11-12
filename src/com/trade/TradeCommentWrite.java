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
		int trade_depth=Integer.parseInt(request.getParameter("trade_depth"));
		String trade_id=request.getParameter("trade_id");
		String user_id=request.getParameter("user_id");
		String trade_comment=request.getParameter("trade_comment");
		String trade_comment_id=request.getParameter("trade_comment_id");
		int num=0;
		if(trade_depth==0) {
			dto=new TradeCommentsDTO(null,trade_id,user_id,trade_comment,null,null,trade_depth);
			num=service.CommentWrite(dto);
			System.out.println("depth가 0일때 결과:"+num+"\n"+dto);
			response.sendRedirect("TradeDetailServlet?trade_id="+trade_id);
		}else if(trade_depth==1) {
			dto=new TradeCommentsDTO(null,trade_id,user_id,trade_comment,null,trade_comment_id,trade_depth);
			try {
				System.out.println("depth:"+trade_depth+"\t"+dto);
				num=service.ReCommentWrite(dto);
				System.out.println("depth가 1일때 결과:"+num+"\n"+dto);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
