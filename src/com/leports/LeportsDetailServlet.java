package com.leports;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.LeportsDetailDTO;
import com.service.LeportsService;

/**
 * Servlet implementation class LeportsDetailServlet
 */
@WebServlet("/LeportsDetailServlet")
public class LeportsDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leports_id = request.getParameter("leports_id");
		
		LeportsService service = new LeportsService();
		LeportsDetailDTO dto = service.leportsDetail(leports_id);
		
		request.setAttribute("leportsDetail", dto);
		
		RequestDispatcher dis = request.getRequestDispatcher("leportsDetail.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
