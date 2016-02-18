package com.first.lastproject.dao;

import com.first.lastproject.dto.MemberDto;

public interface MemberDao {
//member 회원
	public int addMember(MemberDto dto);
	public int modifyMember(MemberDto dto);
	public int checkMember(String id, String passwd);
	public MemberDto getMember(String id);
	public MemberDto getId(String email);
	public MemberDto getPasswd(String id, String email);
	public int makeCoupon(String id);
	public int getCoupon(String id);
	public int addMileage(int food_code, String id);
	public int check(String id); //아이디 중복 체크
	public int findId(String email);
	public int findPasswd(String id, String email);
	
}
