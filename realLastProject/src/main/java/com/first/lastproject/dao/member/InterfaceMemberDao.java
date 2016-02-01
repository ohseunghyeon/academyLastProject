package com.first.lastproject.dao.member;

import com.first.lastproject.dto.MemberDto;

public interface InterfaceMemberDao {
//member 회원
	public int addMember(MemberDto dto);
	public int modifyMember(MemberDto dto);
	public int checkMember(String id, String passwd);
	public MemberDto getMember(String id);
	public int makeCoupon(String id);
	public int getCoupon(String id);
	/*public MemberDto getCouponMileageForMainPage(String id);*/
	
}
