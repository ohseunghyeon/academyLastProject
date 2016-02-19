package com.first.lastproject.dao;

import java.util.Map;

import com.first.lastproject.dto.MemberDto;

public interface MemberDao {
//member 회원
	public int addMember(MemberDto dto);
	public int modifyMember(MemberDto dto);
	public int checkMember(Map<String, String> map2);
	public MemberDto getMember(String id);
	public MemberDto getId(String email);
	public MemberDto getPasswd(Map<String, String> map2);
	public int makeCoupon(String id);
	public int getCoupons(String id);
	public int getCoupon(String id);
	public int checkCoupon(String id);
	public int addMileage(int food_code, String id);
	public int check(String id); //아이디 중복 체크
	public int findId(String email);
	

	
	
}
