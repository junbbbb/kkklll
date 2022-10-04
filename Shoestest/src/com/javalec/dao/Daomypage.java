package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.base.LoginPage;
import com.javalec.dto.Dtocust;
import com.javalec.util.DBConnect;

//------------------------------ 마이페이지 기능 클래스 ------------------------------
public class Daomypage {

	int seqno;
	String name;
	String telno;
	String address;
	String email;
	String relation;

	public Daomypage() {
		// TODO Auto-generated constructor stub
	}

	public Daomypage(String name, String telno, String address, String email, String relation) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	// -------------------- 메인페이지 버튼 클릭 시, 메인페이지 출력 --------------------
	public ArrayList<Dtocust> conditionList() {

		ArrayList<Dtocust> dtoList = new ArrayList<>(); // Dtocust 형태의 ArrayList 선언
		String temp = LoginPage.id; // 테스트용 임시 custid 값 -------> 로그인 성공 시, 해당 custid를 받아서 써야할 것으로 생각됨

		// sql문 선언
		String whereStatement = "select custid, cpw, cname, cphone, caddress from customer "; // DB에서 정보 불러오기
		String whereStatement2 = "where custid = '" + temp + "'"; // custid 값 설정

		// sql문 실행
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // sql에 접속
			Statement stmt_mysql = conn_mysql.createStatement();
			// Statement: sql문 실행 및 리턴에 사용되는 클래스
			// createStatement: 객체, sql문을 java에서 db로 보내는데 사용되는 객체를 생성

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			// ResultSet = db의 result set 데이터 테이블. 최초 커서는 첫 행에 위치됨

			while (rs.next()) {

				String wkCustId = rs.getString(1);
				String wkCpw = rs.getString(2);
				String wkCname = rs.getString(3);
				String wkCphone = rs.getString(4);
				String wkCaddress = rs.getString(5);

				Dtocust dto = new Dtocust(wkCustId, wkCpw, wkCname, wkCphone, wkCaddress);

				dtoList.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	// -------------------- 끝 --------------------

	// -------------------- 회원 정보 업데이트 --------------------

	public boolean updateAction(String cpw, String cname, String cphone, String caddress) {
		PreparedStatement ps = null; // sql 코드 에러 등
		try {
			String temp = LoginPage.id;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update customer set custid = ?, cpw = ?, cname = ?, cphone = ?, caddress = ?"; // 끝에 띄어쓰기
			// 중요, sql
			// 에러걸
			String query2 = "where custid ='" + temp + "'"; // 물음표 순대로 1,2... 밑에 ps.setint에 적용
			ps = conn_mysql.prepareStatement(query + query2); // 나누는 이유: 길어서
			ps.setString(1, temp);
			ps.setString(2, cpw);
			ps.setString(3, cname);
			ps.setString(4, cphone);
			ps.setString(5, caddress);

			ps.executeUpdate(); // 실행, 1이면 정상

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------------- 끝 --------------------

	// -------------------- 회원 탈퇴 --------------------

	public boolean deleteAction() {
		PreparedStatement ps = null; // sql 코드 에러 등
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update customer set coutdate = curdate() "; // 끝에 띄어쓰기
																		// 중요, sql
																		// 에러걸
			String query2 = "where custid ='" + LoginPage.id + "'"; // 물음표 순대로 1,2... 밑에 ps.setint에 적용
			ps = conn_mysql.prepareStatement(query + query2); // 나누는 이유: 길어서

			ps.executeUpdate(); // 실행, 1이면 정상

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------------- 끝 --------------------

} // End