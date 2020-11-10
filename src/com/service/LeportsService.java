package com.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.LeportsDAO;
import com.dto.LeportsDTO;
import com.dto.LeportsDetailDTO;
import com.dto.LeportsReviewDTO;
import com.dto.LeportsThumbnailDTO;

public class LeportsService {
	LeportsDAO dao;
	public LeportsService() {
		// TODO Auto-generated constructor stub
		dao = new LeportsDAO();
	}
	
	//레포츠 상세 페이지에 들어갈 데이터 
	public List<LeportsDetailDTO> leportsDetail(String leports_id) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsDetailDTO> list = null;
		try {
			list = dao.leportsDetail(session, leports_id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return list;
	}
	
	//레포츠 메인페이지에 들어갈 데이터
	public List<LeportsThumbnailDTO> leportsList(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsThumbnailDTO> list = null;
		try {
			list = dao.leportsList(session, map);
		} finally {
			session.close();
		}
		return list;
	}
	
	//레포츠 상세페이지 리뷰 데이터
	public List<LeportsReviewDTO> reviewAll(String leports_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsReviewDTO> list = null;
		
		try {
			list = dao.reviewAll(session, leports_id);
		} finally {
			session.close();
		}
		return list;
	}

}
