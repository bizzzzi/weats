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
	public List<TradeDTO> selectSelf(SqlSession session,String user_id) {
		List<TradeDTO> list=session.selectList("selectSelf",user_id);
		return list;
	}
	public TradeDTO selectItem(SqlSession session,String trade_id){
		TradeDTO dto=session.selectOne("selectItem",trade_id);
		return dto;
	}
	public int CommentWrite(SqlSession session,TradeCommentsDTO dto) {
		int num=session.insert("CommentWrite",dto);
		return num;
	}
	public List<TradeCommentsDTO> CommentList(SqlSession session,String trade_id) {
		List<TradeCommentsDTO> list=session.selectList("CommentList",trade_id);
		return list;
	}
}
