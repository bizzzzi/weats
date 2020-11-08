package com.dto;

public class TradeCommentsDTO {
	private String trade_comment_id;
	private String trade_id;
	private String user_id;
	private String trade_comment;
	private String comment_regidate;
	
	public TradeCommentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeCommentsDTO(String trade_comment_id, String trade_id, String user_id, String trade_comment,
			String comment_regidate) {
		super();
		this.trade_comment_id = trade_comment_id;
		this.trade_id = trade_id;
		this.user_id = user_id;
		this.trade_comment = trade_comment;
		this.comment_regidate = comment_regidate;
	}

	public String getTrade_comment_id() {
		return trade_comment_id;
	}

	public void setTrade_comment_id(String trade_comment_id) {
		this.trade_comment_id = trade_comment_id;
	}

	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
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

	public String getComment_regidate() {
		return comment_regidate;
	}

	public void setComment_regidate(String comment_regidate) {
		this.comment_regidate = comment_regidate;
	}

	@Override
	public String toString() {
		return "TradeCommentsDTO [trade_comment_id=" + trade_comment_id + ", trade_id=" + trade_id + ", user_id="
				+ user_id + ", trade_comment=" + trade_comment + ", comment_regidate=" + comment_regidate + "]";
	}
	
	
}
