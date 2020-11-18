package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.LeportsDTO;
import com.dto.LeportsItemDTO;
import com.dto.PartnerDTO;
import com.dto.ReservationControlDTO;
import com.dto.ReservationDTO;

public class PartnerDAO {
	

	//마이페이지
	public PartnerDTO partnerSelect(SqlSession session,String user_id) {
		PartnerDTO dto=session.selectOne("partnerSelect",user_id);
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
	
	//파트너 탈퇴 키 변경
	public int partner_verifyReset(SqlSession session,String user_id) {
		int n=session.update("partner_verifyReset",user_id);
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
	
	//레포츠 아이디찾기
	public LeportsDTO leportsIdSelect(SqlSession session,String leports_title) {
		LeportsDTO dto=session.selectOne("leportsIdSelect",leports_title);
		return dto;
	}
	
	//등록상품 리스트
	public List<LeportsDTO> ProductControl(SqlSession session,String partner_id) {
		List<LeportsDTO> list=session.selectList("ProductControl",partner_id);
		return list;
	}
	
	//상품 상세 페이지 레포츠
	public LeportsDTO ProductDetailLeports(SqlSession session,String leports_id) {
		LeportsDTO dto=session.selectOne("ProductDetailLeports",leports_id);
		return dto;
	}
	//상품 상세 페이지 아이템
	public LeportsItemDTO ProductDetailItem(SqlSession session,String leports_id) {
		LeportsItemDTO dto=session.selectOne("ProductDetailItem",leports_id);
		return dto;
	}
	
	//레포츠 수정
	public int ProductUpdateLeports(SqlSession session,LeportsDTO dto) {
		int n=session.update("ProductUpdateLeports",dto);
		return n;
	}
	//레포츠 아이템 수정
	public int ProductUpdateItem(SqlSession session,LeportsItemDTO dto) {
		int n=session.update("ProductUpdateItem",dto);
		return n;
	}
	//예약관리
	public List<ReservationControlDTO>  ReservationControl(SqlSession session,String user_id){
		List<ReservationControlDTO> list=session.selectList("ReservationControl",user_id);
		return list;
	}
	
	
}
