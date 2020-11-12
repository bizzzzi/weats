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
import com.encrypt.UserVerify;
import com.service.MemberService;

/**
 * Servlet implementation class passwdCheckServlet
 */
@WebServlet("/passwdCheckServlet")
public class passwdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String page = (String)session.getAttribute("page");
		System.out.println("세션에서 꺼내온 page : " +page);
		MemberDTO sdto = (MemberDTO) session.getAttribute("login");
		String user_email = sdto.getUser_email(); // session에 저장된 user_email parsing
		String curr_pw = request.getParameter("user_pw");

		UserVerify xxx = new UserVerify();// 계정 검증 class

		MemberDTO dto = xxx.verify(user_email, curr_pw);
		
		if (dto != null) { //비버 인증 되면 
			
			System.out.println("비번 인증 성공");
			System.out.println("passwdCheckServlet -> page : "+page);
			
			if(page.equals("delete")) { //회원탈퇴 버튼 클릭 시
				MemberService service = new MemberService();
				service.memberDelete(user_email);
				System.out.println("회원탈퇴 완료");
				session.removeAttribute("login");
				response.sendRedirect("main.jsp");
				
			} else if(page.equals("pwchange")) { //비번 변경 버튼 클릭 시
				RequestDispatcher dis = request.getRequestDispatcher("passwdCheck/passwdChange.jsp");
				dis.forward(request, response);
			}
			 
		} else { //비번 인증 안되면
			System.out.println("비번 인증 실패");
			session.setAttribute("mesg", "비밀번호를 잘못 입력하셨습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("passwdCheckredirect");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
