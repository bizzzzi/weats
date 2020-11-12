package com.dao;
import java.util.HashMap;
import java.util.Map;

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

	public MemberDTO memberLogin(SqlSession session, Map<String, String> map) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAO : 넘어온 데이터"+map);
		MemberDTO dto = session.selectOne("memberLogin", map);
		System.out.println("MemberDAO : db 데이터" + dto);
		return dto;
	}

	public int pwUpdate(SqlSession session, Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.update("pwUpdate", map);
	}

	public int memberDelete(SqlSession session, String user_email) {
		// TODO Auto-generated method stub
		return session.delete("memberDelete", user_email);
	}

}
