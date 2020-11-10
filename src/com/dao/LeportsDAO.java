package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.LeportsDTO;
import com.dto.LeportsDetailDTO;
import com.dto.LeportsReviewDTO;
import com.dto.LeportsThumbnailDTO;

public class LeportsDAO {
	
	//레포츠 상세 페이지
	public List<LeportsDetailDTO> leportsDetail(SqlSession session, String leports_id) {
		// TODO Auto-generated method stub
		System.out.println("DAO : "+leports_id);
		List<LeportsDetailDTO> list = session.selectList("leportsDetailSelect", leports_id); 
		return list;
	}
	
	//레포츠 메인 페이지
	public List<LeportsThumbnailDTO> leportsList(SqlSession session, Map<String, String> map) {
		// TODO Auto-generated method stub
		List<LeportsThumbnailDTO> list = session.selectList("leportsList", map);
		return list;
	}
	//레포츠 상세 페이지 리뷰 부분
	public List<LeportsReviewDTO> reviewAll(SqlSession session, String leports_id) {
		// TODO Auto-generated method stub
		List<LeportsReviewDTO> list = session.selectList("reviewAll", leports_id);
		System.out.println("DAO reviewAll() -> "+ list);
		return list;
	}


}
