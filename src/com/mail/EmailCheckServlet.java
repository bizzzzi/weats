package com.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encrypt.SHA256;
import com.service.MemberService;

/**
 * Servlet implementation class MemberEmailCheckServlet
 */
@WebServlet("/EmailCheckServlet")
public class EmailCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_email = (String)session.getAttribute("user_email"); 
		System.out.println(user_email);
		String code = request.getParameter("code");
		
		MemberService mService = new MemberService();
		
		boolean rightCode = SHA256.getEncrypt(user_email, "cos").equals(code) ? true : false;
		if(rightCode) {
			mService.user_verifyUpdate(user_email);
			session.setAttribute("mesg", "회원가입 성공");
			session.removeAttribute("user_email");
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("SendMailServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
