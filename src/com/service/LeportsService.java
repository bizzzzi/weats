package com.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.LeportsDAO;
import com.dto.LeportsDTO;
import com.dto.LeportsDetailDTO;
import com.dto.LeportsThumbnailDTO;

public class LeportsService {
	LeportsDAO dao;
	public LeportsService() {
		// TODO Auto-generated constructor stub
		dao = new LeportsDAO();
	}
	public List<LeportsDTO> leportsListByType(String type) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsDTO> list = null;
		try {
			list = dao.leportsListByType(session, type);
		} finally {
			session.close();
		}
		return list;
	}
	public List<LeportsDTO> leportsListByLoc(String loc) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsDTO> list = null;
		try {
			list = dao.leportsListByLoc(session, loc);
		} finally {
			session.close();
		}
		return list;
	}
	public LeportsDetailDTO leportsDetail(String leports_id) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		LeportsDetailDTO dto = null;
		try {
			dto = dao.leportsDetail(session, leports_id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return dto;
	}
	public List<LeportsDTO> leportsListAll() {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		List<LeportsDTO> list = null;
		try {
			list = dao.leportsListAll(session);
		} finally {
			session.close();
		}
		return list;
	}
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

}
