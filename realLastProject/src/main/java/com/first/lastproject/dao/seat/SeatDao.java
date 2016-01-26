package com.first.lastproject.dao.seat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.SeatDto;

public class SeatDao implements InterfaceSeatDao {
	DataSource dataSource;
	
	private static SeatDao instance;
	
	public static SeatDao getInstance() {
		if (instance == null) {
			instance = new SeatDao();
		}
		return instance;
	}
	
	private SeatDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public SeatDto getSeats() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public int selectSeats() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public int timeFinishedSeats() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

}
