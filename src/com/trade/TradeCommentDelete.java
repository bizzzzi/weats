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
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.TradeCommentsDTO;
import com.service.TradeService;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Servlet implementation class TradeCommentWrite
 */
@WebServlet("/TradeCommentDelete")
public class TradeCommentDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradeService service=new TradeService();
		String trade_comment_id=request.getParameter("comment_id");
		String user_id=request.getParameter("user_id");
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		int result=0;
		if(user_id.equals(dto.getUser_id())) {
			result=service.CommentDel(trade_comment_id);
		}
		System.out.println("del결과:" + result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
