package com.leports;


import java.io.IOException;
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
		System.out.println("ListServlet : "+map);
		
		
		LeportsService service = new LeportsService();
		List<LeportsThumbnailDTO> list = service.leportsList(map);
		
		for(LeportsThumbnailDTO xxx: list) {
			System.out.println(xxx);
		}
//		if(type != null && loc == null) {
//			list = service.leportsListByType(type);
//		} else if(loc != null && type == null){ 
//			list = service.leportsListByLoc(loc);
//		} else {
//			list = service.leportsListAll();
//		}
		
		
		request.setAttribute("leportsList", list);
		RequestDispatcher dis = request.getRequestDispatcher("leportsList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
