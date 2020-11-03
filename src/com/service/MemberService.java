package com.service;
import java.util.HashMap;

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
	public MemberDTO memberLogin(HashMap<String, String> map) {
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

}
