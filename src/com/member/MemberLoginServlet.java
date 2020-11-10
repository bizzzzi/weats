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
import com.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email =  request.getParameter("user_email");
		String pw  = request.getParameter("user_pw");
		System.out.println("loginServlet : "+pw);
		MemberService service = new MemberService();
		String salt = service.getSaltMember(user_email);
		System.out.println(salt);
		String user_pw = SHA256.getEncrypt(pw, salt);
		
		System.out.println("LoginServlet pw : "+ pw);
		System.out.println("LoginServlet salt : "+ salt);
		System.out.println("LoginServlet user_pw : "+ user_pw);
		
		MemberDTO dto = new MemberDTO();
	
		HashMap<String, String> map = new HashMap<>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		
		dto = service.memberLogin(map);
		
		HttpSession session = request.getSession();
		
		if(dto!=null) {
			session.setAttribute("mesg", "로그인 성공");
			session.setAttribute("login", dto);
		} else {
			session.setAttribute("mesg", "로그인 실패");
		}
		response.sendRedirect("main.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
