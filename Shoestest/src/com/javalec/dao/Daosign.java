package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class Daosign {
	String custid;
	String cname;
	String cpw;
	String cphone;
	String caddress;
	public Daosign() {
		// TODO Auto-generated constructor stub
	}
	public Daosign(String custid, String cname, String cpw, String cphone, String caddress) {
		super();
		this.custid = custid;
		this.cname = cname;
		this.cpw = cpw;
		this.cphone = cphone;
		this.caddress = caddress;
	}
	
	
	

	public Daosign(String custid) {
		super();
		this.custid = custid;
	}
	
	
	public boolean insertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// class선언자
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); //검색할때 쓴다 미리 만들어놓음
			
			String query = "insert into customer (custid, cname, cpw, cphone, caddress, cindate) ";//sql에서는 띄우고 하기때문에 한줄 끝나면 꼭 스페이스바 하나 넣어줘야한다 !!
			String query1 = "values (?,?,?,?,?,curtime() )";
			
			ps = conn_mysql.prepareStatement(query+query1);
			ps.setString(1, custid);//첫번쨰물음표에넣는다
			ps.setString(2, cname);
			ps.setString(3, cpw);
			ps.setString(4, cphone);
			ps.setString(5, caddress);
			
			//실행
			ps.executeUpdate(); // 1값을 반환한다,, 중복값체크도 해야한다.
			
			//
			// 끝나면 연결끊어줘야한다 동시접속 5명이제한이기때문에 ..꼭
			conn_mysql.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;//리턴은 여기서 끝 밑에것 실행안함
		}
		return true;
		
	}
	
	public int idDuplicatedCheck(){
		int check =0;
	
		
		String query = "select count(*) from customer ";//sql에서는 띄우고 하기때문에 한줄 끝나면 꼭 스페이스바 하나 넣어줘야한다 !!
		String query1 = "where custid = '" + custid +"'";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// class선언자
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); //검색할때 쓴다 미리 만들어놓음
			ResultSet rs = stmt_mysql.executeQuery(query+query1);// 워크벤치로 치면 알트앤터쳐서 표시된상태

			
			while (rs.next()) {
				check = rs.getInt(1);
			}

			
			
			
		
			
			
			//
			// 끝나면 연결끊어줘야한다 동시접속 5명이제한이기때문에 ..꼭
			conn_mysql.close();
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
			
			//리턴은 여기서 끝 밑에것 실행안함
		}
		return check;
		
	
	
		
		
	}
	
	
	
	
	
	
	
	
	
}// End
