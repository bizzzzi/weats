package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.LeportsDTO;
import com.dto.LeportsItemDTO;
import com.dto.PartnerDTO;
import com.dto.ReservationDTO;

public class PartnerDAO {

	public String partnerIdSelect(SqlSession session,String user_id) {
		String partner_id=session.selectOne("partnerIdSelect",user_id);
		return partner_id;
	}
	
	//마이페이지
	public PartnerDTO partnerMypageSelect(SqlSession session,String user_id) {
		PartnerDTO dto=session.selectOne("partnerMypageSelect",user_id);
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
	
	//파트너 확인
	public int partner_verifyUpdate(SqlSession session, String user_id) {
		return session.update("partner_verifyUpdate", user_id);
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
	
	//등록상품 리스트
	public List<LeportsDTO> ProductControl(SqlSession session,String partner_id) {
		List<LeportsDTO> list=session.selectList("ProductControl",partner_id);
		return list;
	}
	
	//예약상세
	public LeportsDTO reservationControl(SqlSession session,String leports_id) {
		LeportsDTO dto=session.selectOne("reservationControl",leports_id);
		return dto;
	}
	
	
}
