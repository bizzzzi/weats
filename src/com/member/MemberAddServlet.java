package com.member;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.encrypt.SHA256;
import com.service.MemberService;

/**
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user_name = request.getParameter("user_name");
		String user_email =  request.getParameter("user_email");
		String pw  = request.getParameter("user_pw");
		String salt = SHA256.generateSalt();
		String user_pw = SHA256.getEncrypt(pw, salt); //pw+salt 합쳐서 암호화
		
		System.out.println("addServlet pw : "+ pw);
		System.out.println("addServlet salt : "+ salt);
		System.out.println("addServlet user_pw : "+ user_pw);
		MemberDTO dto = new MemberDTO(null, user_name, user_email, user_pw, salt,	 0, 0);
		MemberService mService = new MemberService();
		
		int n = mService.memberAdd(dto);
		HttpSession session = request.getSession();
		if(n != 0) {
			session.setAttribute("user_email", user_email);
			response.sendRedirect("SendMailServlet"); //인증 이메일 전송
		} else {
			session.setAttribute("mesg", "회원가입 실패, 다시 시도해주세요.");
			response.sendRedirect("main.jsp");
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
