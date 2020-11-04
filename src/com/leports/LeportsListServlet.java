package com.leports;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.LeportsDTO;
import com.dto.LeportsThumbnailDTO;
import com.service.LeportsService;

/**
 * Servlet implementation class LeportsListServlet
 */
@WebServlet("/LeportsListServlet")
public class LeportsListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String loc = request.getParameter("loc");
		if(type == null && loc == null) type = "all";
		request.setAttribute("category", category);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("loc", loc);
		
		
		LeportsService lService = new LeportsService();
		List<LeportsThumbnailDTO> list = lService.leportsList(map); //레포츠 전체 출력(레포츠 아이디 중복 포함)
		
		List<LeportsThumbnailDTO> list1 = new ArrayList(); //중복 제거해서 담을 리스트
		if(list.size() != 0) {
			LeportsThumbnailDTO ddd = list.get(0); //전체 받아온 리스트에서 0번째 리스트를 dto객체에 주입
			list1.add(ddd);//주입받은 객체를 중복 제거 할 리스트에 주입
			for(LeportsThumbnailDTO xxx: list) { //전체 리스트 사이즈만큼 반복
				if(xxx.getLeports_id().equals(ddd.getLeports_id())) { //전체 리스트의 첫번 째 객체랑 주입받은 객체랑 비교
					System.out.println("if문 true"); //같으면 아무동작 안함
				} else {
					ddd = xxx; //다르면 list에 있는 객체를 ddd에 대입
					list1.add(ddd); //바뀐 ddd객체를 중복 제거 리스트에 주입
				}
			}
		}
		System.out.println("걸러진 리스트(LeportsListServlet) :"+list1); 
		
		
		request.setAttribute("leportsList", list1); //중복 제거한 리스트를 request.setAttribute();
		RequestDispatcher dis = request.getRequestDispatcher("/leports/leportsList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
