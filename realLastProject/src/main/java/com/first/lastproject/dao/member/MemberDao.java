package com.first.lastproject.dao.member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao implements InterfaceMemberDao {
DataSource dataSource;
	
	private static MemberDao instance;
	
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	private MemberDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addMemeber() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public int modifyMember() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

}
