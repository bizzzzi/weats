package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.PartnerDAO;
import com.dto.LeportsDTO;
import com.dto.LeportsItemDTO;
import com.dto.PartnerDTO;
import com.dto.ReservationDTO;

public class PartnerService {
	
	public String partnerIdSelect(String user_id) {
		SqlSession session=MySqlSessionFactory.getSession();
		String partner_id="";
		try {
			PartnerDAO dao=new PartnerDAO();
			partner_id=dao.partnerIdSelect(session, user_id);
		}finally {
			session.close();
		}
		return partner_id;
	}
	
	//마이페이지
	public PartnerDTO partnerMypageSelect(String user_id) {
		SqlSession session=MySqlSessionFactory.getSession();
		PartnerDTO dto=null;
		try {
			PartnerDAO dao=new PartnerDAO();
			dto=dao.partnerMypageSelect(session,user_id);
		}finally {
			session.close();
		}
		return dto;
	}
	//마이페이지 수정
	public int partnerUpdate(PartnerDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n=dao.partnerUpdate(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	//파트너 탈퇴
	public int partnerDelete(String partner_id) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n=dao.partnerDelete(session, partner_id);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	
	//파트너 등록
	public int partnerInsert(PartnerDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n=dao.partnerInsert(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	//파트너 등록 확인
	public void partner_verifyUpdate(String user_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n = dao.partner_verifyUpdate(session, user_id);
			if(n != 0) {
				session.commit();				
			} else {
				session.rollback();
			}	
		} finally {
			session.close();
		}
	}
	
	//레포츠 등록
	public int leportsInsert(LeportsDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n=dao.leportsInsert(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	//레포츠 아이템 등록
	public int leportsItemInsert(LeportsItemDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			PartnerDAO dao=new PartnerDAO();
			n=dao.leportsItemInsert(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	//예약 상세
	public LeportsDTO reservationControl(String leports_id) {
		SqlSession session=MySqlSessionFactory.getSession();
		LeportsDTO dto=null;
		try {
			PartnerDAO dao=new PartnerDAO();
			dto=dao.reservationControl(session, leports_id);
		}finally {
			session.commit();
		}
		return dto;
	}
	
	//등록상품 리스트
	public List<LeportsDTO> ProductControl(String partner_id){
		SqlSession session=MySqlSessionFactory.getSession();
		List<LeportsDTO> list=null;
		try {
			PartnerDAO dao=new PartnerDAO();
			list=dao.ProductControl(session, partner_id);
		}finally {
			session.close();
		}
		return list;
	}

	
}
