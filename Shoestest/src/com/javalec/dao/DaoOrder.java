package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.base.LoginPage;
import com.javalec.dto.Dtomain;
import com.javalec.dto.Dtoorder;
import com.javalec.util.DBConnect;

public class DaoOrder {

	// F
	String orderid;
	String customer_custid;
	String product_proid;
	String oquantity;
	String odate;
	
//	String proid;
//	String pname;
//	String pbrand;
//	int pprice;
//	int psize;
//	String pcolor;
//	int pinvenquantity;
//	String preceiptdate;
//	
//	String custid;
//	String cname;
//	String cpw;
//	String cphone;
//	String caddress;
	
	
	// C
	
	public DaoOrder() {
		// TODO Auto-generated constructor stub
	}
	
	
	// M
	// DB값을 Table에 넣어보자! SelectList
		public ArrayList<Dtoorder> selectList(){
			
			ArrayList<Dtoorder> dtoList = new ArrayList<Dtoorder>();
			
			String whereStatement = "select o.orderid, o.odate, c.cname, o.product_proid, o.oquantity, ";
			String whereStatement2 = "p.pname, p.pbrand, p.pprice, p.psize, p.pcolor from product p, orders o, customer c ";
			String whereStatement3 = "where o.customer_custid = '" + LoginPage.id + "' and " ;
			String whereStatement4 = "p.proid = o.product_proid and c.custid = o.customer_custid";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 연결
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				// 데이터베이스에 접근을 하겠다 선언한것이다.

				// 입력할떄 필요없음 검색할떄 필요함
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3 + whereStatement4);

				// while은 false 하면 끝나버림
				while (rs.next()) {
					
					int wkOrderid = rs.getInt(1);
					String wkOrderdate = rs.getString(2); // 컬럼이름쓰던가 번호쓰던가 내맘임
					String wkCname = rs.getString(3);
					String wkProid = rs.getString(4);
					int wkOrderquan= rs.getInt(5);
					String wkPname = rs.getString(6);
					String wkPbrand = rs.getString(7);
					int wkPprice = rs.getInt(8);
					int wkPsize = rs.getInt(9);
					String wkPcolor = rs.getString(10);
					
					Dtoorder dto = new Dtoorder(wkOrderid, wkProid, wkOrderquan, wkOrderdate, wkPname, wkPbrand, wkPprice, wkPsize, wkPcolor, wkCname);
					
					dtoList.add(dto);
				}

				conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

			} catch (Exception e) {
				e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
			}
			return dtoList;
		}//Select List	
	
	
}// End

