package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.javalec.dto.Dtocust;
import com.javalec.util.DBConnect;

public class Daologin {
   //field
   String custid;
   String cpw;
   String cname;
   String caddress;
   String cphone;
   String cindate;
   String coutdate;
   
   //c
   public Daologin() {
      // TODO Auto-generated constructor stub
   }

   public Daologin(String custid, String cpw) {
      super();
      this.custid = custid;
      this.cpw = cpw;
   }
   
   //m
   public int customerCheck() {
      PreparedStatement ps = null;
      int check=0;
      
       String whereStatement = "select count(*) from customer where custid='"+custid+"' and cpw='"+cpw+"' and coutdate is null ";
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             // 연결
             Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
             // 데이터베이스에 접근을 하겠다 선언한것이다.

             // 입력할떄 필요없음 검색할떄 필요함
             Statement stmt_mysql = conn_mysql.createStatement();

             ResultSet rs = stmt_mysql.executeQuery(whereStatement);
             
              while (rs.next()) {
                 check = rs.getInt(1);
                  
                  
              }
              
              conn_mysql.close();


          } catch (Exception e) {
             e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
          }
         return check;
   }
  
	}
   
   
   
}//End

//여기에는 메인에서값받은걸 토대로 워크벤치에 넣어주는 메소드..

      
