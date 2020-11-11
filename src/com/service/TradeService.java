package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TradeDAO;
import com.dto.TradeCommentsDTO;
import com.dto.TradeDTO;

public class TradeService {
	TradeDAO dao;
	public TradeService() {
		dao=new TradeDAO();
	}
	public List<TradeDTO> selectTrade(String trade_type) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<TradeDTO> list=null;
		try {
			list=dao.selectTrade(session, trade_type);
		}finally {
			session.close();
		}return list;
	}

	public int tradeWrite(TradeDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try {
			num = dao.tradeWrite(session, dto);
			if(num != 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return num;
	}
	public List<TradeDTO> selectSelf(String user_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<TradeDTO> list=null;
		try {
			list=dao.selectSelf(session, user_id);
		}finally {
			session.close();
		}return list;
	}
	public TradeDTO selectItem(String trade_id) {
		SqlSession session=MySqlSessionFactory.getSession();
		TradeDTO dto=null;
		try {
			dto=dao.selectItem(session, trade_id);
		}finally {
			session.close();
		}return dto;
	}
	public int CommentWrite(TradeCommentsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try {
			num = dao.CommentWrite(session, dto);
			System.out.println("service"+"\t"+dto);
			if(num != 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return num;
	}
	public int ReCommentWrite(TradeCommentsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println("service대댓글"+dto);
		int num = 0;
		try {
			num = dao.ReCommentWrite(session, dto);
			if(num != 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return num;
	}
	public List<TradeCommentsDTO> CommentList(String trade_id){
		SqlSession session=MySqlSessionFactory.getSession();
		List<TradeCommentsDTO> list=null;
		try {
			list=dao.CommentList(session, trade_id);
		}finally {
			session.close();
		}return list;
	}
	
}
