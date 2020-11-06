package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.TradeDTO;

public class TradeDAO {
	public TradeDAO() {
		super();
	}
	public List<TradeDTO> selectTrade(SqlSession session,String trade_type) {
		List<TradeDTO> list=session.selectList("selectTrade",trade_type);
		return list;
	}
	public int tradeWrite(SqlSession session,TradeDTO dto) {
		int num = session.insert("tradeWrite",dto);
		return num;
	}
}
