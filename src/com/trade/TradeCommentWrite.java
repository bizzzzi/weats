package com.trade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TradeCommentsDTO;
import com.service.TradeService;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Servlet implementation class TradeCommentWrite
 */
@WebServlet("/TradeCommentWrite")
public class TradeCommentWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
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
				System.out.println("최송락:"+dto);
				num = service.ReCommentWrite(dto);
				trade_comment_id = dto.getTrade_comment_id();
				System.out.println("테스트ㅡㅡ트트틑트트틑"+"\t"+trade_comment_id);
				System.out.println("depth가 1일때 결과:"+num+"\n"+dto);
				PrintWriter out = response.getWriter();
				out.print(dto);
				
//				Map<String,String> map=new HashMap<String, String>();
//				map.put("trade_comment_id", trade_comment_id);
//				map.put("num", "test");
//				out.print(map);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
//		dto = service.
//		out.print(dto);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
