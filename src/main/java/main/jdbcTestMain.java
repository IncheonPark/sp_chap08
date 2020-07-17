package main;

import java.sql.SQLException;

import spring.Member;
import spring.jdbcTest;

//Mysql 데이터베이스 연결 테스트용 메인 클래스
public class jdbcTestMain {

	private static jdbcTest jt = new jdbcTest();
	private static Member member;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		select();

	}
	
	private static void select() throws SQLException, ClassNotFoundException {
		member = jt.select();
		System.out.println(member.getId() + ":" + member.getEmail() + ":" + member.getName());
	}

}
