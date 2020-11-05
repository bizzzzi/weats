package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.LeportsDTO;
import com.dto.LeportsDetailDTO;
import com.dto.LeportsThumbnailDTO;

public class LeportsDAO {
	
    //레포츠 종류별
	public List<LeportsDTO> leportsListByType(SqlSession session, String type) {
		// TODO Auto-generated method stub
		List<LeportsDTO> list = session.selectList("leportsListByType", type);
		return list;
	}
	
	//레포츠 지역별
	public List<LeportsDTO> leportsListByLoc(SqlSession session, String loc) {
		// TODO Auto-generated method stub
		List<LeportsDTO> list = session.selectList("leportsListLoc", loc);
		return list;
	}

	//레포츠 상세 페이지
	public LeportsDetailDTO leportsDetail(SqlSession session, String leports_id) {
		// TODO Auto-generated method stub
		LeportsDetailDTO dto = session.selectOne("leportsDetailSelect", leports_id); 
		return dto;
	}

	public List<LeportsDTO> leportsListAll(SqlSession session) {
		// TODO Auto-generated method stub
		List<LeportsDTO> list = session.selectList("leportsListAll");
		return list;
	}
	
	public List<LeportsThumbnailDTO> leportsList(SqlSession session, Map<String, String> map) {
		// TODO Auto-generated method stub
		List<LeportsThumbnailDTO> list = session.selectList("leportsList", map);
		return list;
	}


}
