package com.dto;

public class TradeReCommentsDTO {
	private String trade_recomment_id;
	private String trade_comment_id;
	private String user_id;
	private String trade_comment;
	private int depth;
	private String comment_regidate;
	public TradeReCommentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TradeReCommentsDTO(String trade_recomment_id, String trade_comment_id, String user_id, String trade_comment,
			int depth, String comment_regidate) {
		super();
		this.trade_recomment_id = trade_recomment_id;
		this.trade_comment_id = trade_comment_id;
		this.user_id = user_id;
		this.trade_comment = trade_comment;
		this.depth = depth;
		this.comment_regidate = comment_regidate;
	}
	public String getTrade_recomment_id() {
		return trade_recomment_id;
	}
	public void setTrade_recomment_id(String trade_recomment_id) {
		this.trade_recomment_id = trade_recomment_id;
	}
	public String getTrade_comment_id() {
		return trade_comment_id;
	}
	public void setTrade_comment_id(String trade_comment_id) {
		this.trade_comment_id = trade_comment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTrade_comment() {
		return trade_comment;
	}
	public void setTrade_comment(String trade_comment) {
		this.trade_comment = trade_comment;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getComment_regidate() {
		return comment_regidate;
	}
	public void setComment_regidate(String comment_regidate) {
		this.comment_regidate = comment_regidate;
	}
	@Override
	public String toString() {
		return "TradeReCommentsDTO [trade_recomment_id=" + trade_recomment_id + ", trade_comment_id=" + trade_comment_id
				+ ", user_id=" + user_id + ", trade_comment=" + trade_comment + ", depth=" + depth
				+ ", comment_regidate=" + comment_regidate + "]";
	}
	
	
}
