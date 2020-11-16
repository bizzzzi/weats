package com.encrypt;

import java.util.HashMap;
import java.util.Map;

import com.dto.MemberDTO;
import com.service.MemberService;

public class UserVerify {
	
	public MemberDTO verify(String user_email, String curr_pw) {
		MemberService service = new MemberService();
		String salt = service.getSaltMember(user_email); //이메일로 salt 값 select
		System.out.println(salt);
		String user_pw = SHA256.getEncrypt(curr_pw, salt);  //입력한 비번 + salt 암호화
		
		//map에 담아서 일치하는 계정이 있는지 검사
		Map<String ,String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		
		MemberDTO dto = service.memberLogin(map);
		MemberDTO xxx = null;
		if(dto != null) {
			xxx = dto;
		}
		return xxx;
	}
	
}
