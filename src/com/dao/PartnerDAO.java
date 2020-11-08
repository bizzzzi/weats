package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.LeportsDTO;
import com.dto.LeportsItemDTO;
import com.dto.PartnerDTO;
import com.dto.ReservationDTO;

public class PartnerDAO {
	//user_id select
	public String selectUserid(SqlSession session,String user_email) {
		String userid=session.selectOne("selectUserid",user_email);
		return userid;
	}
	
	//마이페이지
	public PartnerDTO partnerMypageSelect(SqlSession session,String partner_id) {
		PartnerDTO dto=session.selectOne("partnerMypageSelect",partner_id);
		return dto;
	}
	//마이페이지 수정
	public int partnerUpdate(SqlSession session,PartnerDTO dto) {
		int n=session.update("partnerUpdate",dto);
		return n;
	}
	//파트너 탈퇴
	public int partnerDelete(SqlSession session,String partner_id) {
		int n=session.delete("partnerDelete",partner_id);
		return n;
	}
	
	//파트너 등록
	public int partnerInsert(SqlSession session,PartnerDTO dto) {
		int n=session.insert("partnerInsert",dto);
		return n;
	}
	
	//래포츠 등록
	public int leportsInsert(SqlSession session,LeportsDTO dto) {
		int n=session.insert("leportsInsert",dto);
		return n;
	}
	
	//레포츠 아이템
	public int leportsItemInsert(SqlSession session,LeportsItemDTO dto) {
		int n=session.insert("leportsItemInsert",dto);
		return n;
	}
	
	//예약상세
	public LeportsDTO reservationControl(SqlSession session,String leports_id) {
		LeportsDTO dto=session.selectOne("reservationControl",leports_id);
		return dto;
	}
	
	
}
