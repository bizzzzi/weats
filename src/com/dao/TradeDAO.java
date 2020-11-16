package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.TradeCommentsDTO;
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
	public int ReCommentWrite(SqlSession session,TradeCommentsDTO dto) {
		System.out.println("dao대댓글"+dto);
		return session.insert("ReCommentWrite",dto);
	}
	public List<TradeCommentsDTO> CommentList(SqlSession session,String trade_id) {
		List<TradeCommentsDTO> list=session.selectList("CommentList",trade_id);
		return list;
	}
	public String CommentRegidate(SqlSession session,String trade_comment_id) {
		String regidate=session.selectOne("CommentRegidate",trade_comment_id);
		return regidate;
	}
	
	public int CommentDel(SqlSession session,String trade_comment_id) {
		int result=session.delete("CommentDel",trade_comment_id);
		return result;
	}
	
}
