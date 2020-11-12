package com.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.encrypt.SHA256;
import com.encrypt.UserVerify;
import com.service.MemberService;

/**
 * Servlet implementation class MemberPasswdChange
 */
@WebServlet("/MemberPasswdChange")
public class MemberPasswdChange extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String user_email = dto.getUser_email(); //session에 저장된 user_email parsing
		
//		String user_email = "acornjava@gmail.com"; 
		
		String change_pw = request.getParameter("new_pw"); //사용자가 입력한 바꿀 비번
		String salt = service.getSaltMember(user_email); //이메일로 salt값 가져오기
		String new_pw = SHA256.getEncrypt(change_pw, salt); //pw+salt 합쳐서 암호화
		System.out.println("loginServlet : "+new_pw);
		
			Map<String, String> map = new HashMap<String, String>();
			map.put("user_email", user_email);
			map.put("user_pw", new_pw);
			service.pwUpdate(map);
			System.out.println("변경 성공");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
