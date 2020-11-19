package com.partner;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LeportsDTO;
import com.dto.MemberDTO;
import com.dto.PartnerDTO;
import com.dto.ReservationControlDTO;
import com.dto.ReservationDTO;
import com.service.PartnerService;

/**
 * Servlet implementation class ReservationControl
 */
@WebServlet("/ReservationControl")
public class ReservationControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session=request.getSession();
				PartnerDTO dto=(PartnerDTO)session.getAttribute("partner");
				String user_id=dto.getUser_id();
				
				PartnerService pservice=new PartnerService();
				List<ReservationControlDTO> list=pservice.ReservationControl(user_id);
				
			System.out.println(list);
				if(list!=null) {
				session.setAttribute("leportsList", list);
				}
				RequestDispatcher dis=request.getRequestDispatcher("partner/reservationControl.jsp");
				dis.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
