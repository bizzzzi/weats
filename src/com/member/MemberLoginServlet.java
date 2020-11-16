package com.member;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.dto.MemberDTO;
import com.encrypt.SHA256;
import com.encrypt.UserVerify;
import com.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email =  request.getParameter("user_email");
		String pw  = request.getParameter("user_pw");
		
		UserVerify xxx = new UserVerify();//계정 검증 class
		
		MemberDTO dto = xxx.verify(user_email, pw); 
		HttpSession session = request.getSession();
		
		if(dto!=null) {
			session.setAttribute("mesg", "로그인 성공");
			session.setAttribute("login", dto);
		} else {
			session.setAttribute("mesg", "로그인 실패");
		}
		response.sendRedirect("PartnerKeyCheckServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
