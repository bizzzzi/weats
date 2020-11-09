package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TradeDAO;
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
}
