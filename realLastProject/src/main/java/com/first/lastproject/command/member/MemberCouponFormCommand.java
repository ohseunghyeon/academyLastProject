package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;


public class MemberCouponFormCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = (String) request.getSession().getAttribute("id");
		
		MemberDao memberDao = MemberDaoImpl.getInstance();
		int coupon_code = memberDao.getCoupon(id);
		
		
			
		model.addAttribute("coupon_code", coupon_code);
		return "member/p_coupon/coupon";
		
		
	}

}
