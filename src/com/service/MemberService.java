package com.service;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	MemberDAO dao;
	public MemberService() {
		// TODO Auto-generated constructor stub
		dao = new MemberDAO();
	}
	
	//회원가입
	public int memberAdd(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.memberAdd(session, dto);
			if(n != 0) {
				session.commit();
				System.out.println("memberAdd Commit@@");
			} else {
				System.out.println("memberAdd Rollback@@");
				session.rollback();
			}	
		}	finally {
			// TODO: handle finally clause
			session.close();
		}
		return n;
	}
	
	//이메일 인증 검증
	public void user_verifyUpdate(String user_email) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			n = dao.user_verifyUpdate(session, user_email);
			if(n != 0) {
				session.commit();
				System.out.println("user_verifyUpdate Commit@@@@@");
			} else {
				System.out.println("user_verifyUpdate Rollback@@");
				session.rollback();
			}	
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}
	
	//회원의 salt키 추출
	public String getSaltMember(String user_email) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		String salt;
		try {
			salt = dao.getSaltMember(session, user_email);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return salt;
	}
	
	//로그인 
	public MemberDTO memberLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto; 
		try {
			dto = dao.memberLogin(session, map);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return dto;
	}

	public void pwUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int n;
		try {
			n = dao.pwUpdate(session, map);
			if(n > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
	}
	
	public void memberDelete(String user_email) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int n;
		try {
			n = dao.memberDelete(session, user_email);
			if(n>0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
		
	}

}
