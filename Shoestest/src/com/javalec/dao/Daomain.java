package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.LoginPage;
import com.javalec.base.Mainshoes;
import com.javalec.base.Purchase;
import com.javalec.dto.Dtocust;
import com.javalec.dto.Dtomain;
import com.javalec.util.DBConnect;

public class Daomain {

	// Field
	String proid;
	String pname;
	String pbrand;
	int pprice;
	int psize;
	String pcolor;
	int pinvenquantity;
	String preceiptdate;
	
	String conname; //컬럼이름
	String condata; //데이터값
	
	
	//Construct 
	public Daomain() {
		// TODO Auto-generated constructor stub
	}




	public Daomain(String proid) {
		super();
		this.proid = proid;
	}


	public Daomain(String proid, String pname, String pbrand, int pprice, int psize, String pcolor, int pinvenquantity) {
		super();
		this.proid = proid;
		this.pname = pname;
		this.pbrand = pbrand;
		this.pprice = pprice;
		this.psize = psize;
		this.pcolor = pcolor;
		this.pinvenquantity = pinvenquantity;
	}

	public Daomain(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}


	//----method
	// DB값을 Table에 넣어보자! SelectList
	public ArrayList<Dtomain> selectList(){
		
		ArrayList<Dtomain> dtoList = new ArrayList<Dtomain>();
		
		String whereStatement = "select proid, pname, pbrand, pprice, psize, pcolor, pinvenquantity from product ";
		//String whereStatement = "select pname, pbrand, pprice, psize, pcolor, pinvenquantity from product";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			// 데이터베이스에 접근을 하겠다 선언한것이다.

			// 입력할떄 필요없음 검색할떄 필요함
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			// while은 false 하면 끝나버림
			while (rs.next()) {
				
				String wkProid = rs.getString(1);
				String wkPname = rs.getString(2); // 컬럼이름쓰던가 번호쓰던가 내맘임
				String wkPbrand = rs.getString(3);
				int wkPprice = rs.getInt(4);
				int wkPsize = rs.getInt(5);
				String wkPcolor = rs.getString(6);
				int wkPinvenquantity = rs.getInt(7);
				
				Dtomain dto = new Dtomain(wkProid, wkPname, wkPbrand, wkPprice, wkPsize, wkPcolor, wkPinvenquantity);
				dtoList.add(dto);
			}

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		}
		return dtoList;
	}//Select List
	//--------------------------------------------------------------------------------------------------------
	
	// Table을 Click 하였을 경우
	public Dtomain tableClick() {
		
		Dtomain dto = null; //왜 널썻는지
		
		String whereStatement = "select proid, pname, pbrand, pprice,  psize, pcolor, pinvenquantity from product ";
		String whereStatement2 = "where proid = '" + proid +"'";// < 이걸 가져와야 쓸 수 있는 메소드다. 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			// 데이터베이스에 접근을 하겠다 선언한것이다.

			// 입력할떄 필요없음 검색할떄 필요함
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			// 하나 가져오느건 와일안쓰고 이프써도됨니다
			if (rs.next()) {
				String wkProid = rs.getString(1);
				String wkPname = rs.getString(2);
				String wkPbrand = rs.getString(3);
				int wkPprice = rs.getInt(4);
				int wkPsize = rs.getInt(5);
				String wkPcolor = rs.getString(6);
				int wRPquantity = rs.getInt(7);
				
				dto = new Dtomain(wkProid, wkPname, wkPbrand, wkPprice, wkPsize, wkPcolor, wRPquantity); //Dto를 만든거임 데이터를 각자불러와서 한 박스에만 넣음.
			}

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		}
		return dto;
	}
	
	// ConditionList
	public ArrayList<Dtomain> conditionList(){ //데이터 많을거니깐 어레이리스트 쓴다
		
		ArrayList<Dtomain> dtoList = new ArrayList<Dtomain>();
		
		String whereStatement = "select proid, pname, pbrand, pprice, psize, pcolor, pinvenquantity from product ";
		String whereStatement2 = "where "+ conname + " like '%" + condata + "%'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);

			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			// while은 false 하면 끝나버림
			while (rs.next()) {
				
				String wkProid = rs.getString(1);
				String wkPname = rs.getString(2);
				String wkPbrand = rs.getString(3);
				int wkPprice = rs.getInt(4);
				int wkPsize = rs.getInt(5);
				String wkPcolor = rs.getString(6);
				int wRPquantity = rs.getInt(7);
				
				Dtomain dto = new Dtomain(wkProid, wkPname, wkPbrand, wkPprice, wkPsize, wkPcolor, wRPquantity);
				dtoList.add(dto);
			}

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		}
		return dtoList;
	}
	
	// Table을 Click 하였을 경우
	public Dtocust myName() {
		
		Dtocust dto = null; //왜 널썻는지
		
		String whereStatement = "select cname from customer ";
		String whereStatement2 = "where custid = '" + proid +"'";// < 이걸 가져와야 쓸 수 있는 메소드다. 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			// 데이터베이스에 접근을 하겠다 선언한것이다.

			// 입력할떄 필요없음 검색할떄 필요함
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			// 하나 가져오느건 와일안쓰고 이프써도됨니다
			if (rs.next()) {
				String wkCname = rs.getString(1);
				
				dto = new Dtocust(wkCname); //Dto를 만든거임 데이터를 각자불러와서 한 박스에만 넣음.
			}

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		}
		return dto;
	}
	
	// InsertAction
	public boolean insertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);


			String query = "insert into orders (customer_custid, product_proid, oquantity, odate ) "; // 인서트하는애임
			String query1 = "values (?, ?, ?, curdate()) ";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, LoginPage.id);
			ps.setString(2, Mainshoes.wkProid);
			ps.setInt(3, Purchase.a);

			ps.executeUpdate(); // 실행하기

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

			// JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력되었습니다.");

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
			return false;
		}
		return true;
	}
	
	
	 public boolean updateAction() {
	      PreparedStatement ps = null; // sql 코드 에러 등
	      try {
	    	 String temp = Mainshoes.wkProid;
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
	               DBConnect.pw_mysql);
	         Statement stmt_mysql = conn_mysql.createStatement();

	         String query = "update product set pinvenquantity = pinvenquantity - ? "; // 끝에 띄어쓰기
	                                                                                 // 중요, sql
	                                                                                 // 에러걸
	         String query2 = "where proid ='" + temp + "'"; // 물음표 순대로 1,2... 밑에 ps.setint에 적용
	         ps = conn_mysql.prepareStatement(query + query2); // 나누는 이유: 길어서
	         ps.setString(1, Integer.toString(Purchase.a));
	         

	         ps.executeUpdate(); // 실행, 1이면 정상

	         conn_mysql.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }
	
}//END
