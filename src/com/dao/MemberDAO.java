package com.dao;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int memberAdd(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		return session.insert("memberAdd", dto);
	}
	
	public int user_verifyUpdate(SqlSession session, String user_email) {
		// TODO Auto-generated method stub
		return session.update("user_verifyUpdate", user_email);
	}

	public String getSaltMember(SqlSession session, String user_email) {
		// TODO Auto-generated method stub
		
		return session.selectOne("searchSalt", user_email);
	}

	public MemberDTO memberLogin(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
		return session.selectOne("memberLogin", map);
	}

}
