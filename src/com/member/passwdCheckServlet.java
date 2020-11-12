package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.encrypt.UserVerify;
import com.service.MemberService;

/**
 * Servlet implementation class passwdCheckServlet
 */
@WebServlet("/passwdCheckServlet")
public class passwdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();

		String page = request.getParameter("page");
		MemberDTO sdto = (MemberDTO) session.getAttribute("login");
		String user_email = sdto.getUser_email(); // session에 저장된 user_email parsing
		String curr_pw = request.getParameter("user_pw");

		UserVerify xxx = new UserVerify();// 계정 검증 class

		MemberDTO dto = xxx.verify(user_email, curr_pw);
		
		String nextPage = "";
		if (dto != null) {
			System.out.println("비번 인증 성공");
			System.out.println(page);
			if(page.equals("delete")) {
				System.out.println("회원가입 폼 이동");
			} else if(page.equals("pwchange")) {
				response.sendRedirect("test.jsp");
			}
			
		} else {
			System.out.println("비번 인증 실패");
			session.setAttribute("mesg", "비밀번호  다름");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
