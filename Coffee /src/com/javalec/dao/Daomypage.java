package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.Login;
import com.javalec.dto.Dtocustomer;
import com.javalec.util.DBConnect;

public class Daomypage {
	
	// Field 
	String custid;
	String ctelno;
	String cname;
	String custpw;
	String cnickname;	
	String caddress;
	String cquestion;
	String canswer;
	String cemail;
	String cindate;
	FileInputStream cimage;
	String cupdatedate;
	
	// Constructor
	public Daomypage() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Daomypage(String custpw, String cname, String ctelno, String caddress, String cemail, String cnickname,
			String cquestion, String canswer, FileInputStream cimage) {
		super();
		this.ctelno = ctelno;
		this.cname = cname;
		this.custpw = custpw;
		this.cnickname = cnickname;
		this.caddress = caddress;
		this.cquestion = cquestion;
		this.canswer = canswer;
		this.cemail = cemail;
		this.cimage = cimage;
	}
	
	public Daomypage(String custpw, String cname, String ctelno, String caddress, String cemail, String cnickname,
			String cquestion, String canswer) {
		super();
		this.ctelno = ctelno;
		this.cname = cname;
		this.custpw = custpw;
		this.cnickname = cnickname;
		this.caddress = caddress;
		this.cquestion = cquestion;
		this.canswer = canswer;
		this.cemail = cemail;
	}





	// Method
	
	   // -------------------- 메인페이지 버튼 클릭 시, 메인페이지 출력 --------------------
	   public Dtocustomer selectList() {
//ArrayList<Dtocustomer>
//	      ArrayList<Dtocustomer> dtoList = new ArrayList<>(); // Dtocust 형태의 ArrayList 선언
		   Dtocustomer dtolist = null;
	      // sql문 선언
	      String whereStatement = "select custid, custpw, cname, ctelno, caddress, cemail, cnickname, cquestion, canswer, cimage from customer "; // DB에서 정보 불러오기
	      String whereStatement2 = "where custid = '" + Login.id + "'"; // custid 값 설정
	      
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
	            String wkCustpw = rs.getString(2);
	            String wkCname = rs.getString(3);
	            String wkCtelno = rs.getString(4);
	            String wkCaddress = rs.getString(5);
	            String wkCemail = rs.getString(6);
	            String wkCnickname = rs.getString(7);
	            String wkCquestion = rs.getString(8);
	            String wkCanswer = rs.getString(9);
//            	String wkFilename = rs.getString(10);
            	
            	// File
            	DBConnect.cimagename = DBConnect.cimagename + 1;
            	File file = new File(Integer.toString(DBConnect.cimagename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(10);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	

	            dtolist = new Dtocustomer(wkCustId, wkCustpw, wkCname, wkCtelno, wkCaddress, wkCemail, wkCnickname, wkCquestion, wkCanswer );

//	            dtoList.add(dto);
	         }
	         conn_mysql.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return dtolist;
	   }
	
	   // Update Action
		// 수정 (이미지를 변경했을때)
		public boolean UpdateAction() {
			  PreparedStatement ps = null;
			  try{
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			      @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
			
			      String A = "update customer set custpw = ?, cname = ?, ctelno = ?, caddress = ?, cemail = ?, cnickname = ?, cquestion = ?, canswer =?, cimage = ? , cupdatedate = curdate() ";
			      String B = " where custid = '" + Login.id + "'"; 
			
			      ps = conn_mysql.prepareStatement(A+B);
			      
			      ps.setString(1, custpw);
			      ps.setString(2, cname);
			      ps.setString(3, ctelno);
			      ps.setString(4, caddress);
			      ps.setString(5, cemail);
			      ps.setString(6, cnickname);
			      ps.setString(7, cquestion);
			      ps.setString(8, canswer);
			      ps.setBinaryStream(9, cimage);
			      ps.executeUpdate();
			
			      conn_mysql.close();
			  } catch (Exception e){
			      e.printStackTrace();
			      return false;
			  }
			
			  return true;
		}
		// 수정 (이미지를 변경하지 않았을)
		public boolean UpdateActionnoimage() {
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String A = "update customer set custpw = ?, cname = ?, ctelno = ?, caddress = ?, cemail = ?, cnickname = ?, cquestion = ?, canswer =?,  cupdatedate = curdate() ";
				String B = " where custid = '" + Login.id + "'"; 
				
				ps = conn_mysql.prepareStatement(A+B);
				
				ps.setString(1, custpw);
				ps.setString(2, cname);
				ps.setString(3, ctelno);
				ps.setString(4, caddress);
				ps.setString(5, cemail);
				ps.setString(6, cnickname);
				ps.setString(7, cquestion);
				ps.setString(8, canswer);
				ps.executeUpdate();
				
				conn_mysql.close();
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
	
	
	
	
	
	

} // END
