package com.javalec.dto;

//------------------------------ 마이페이지 Dto 클래스 ------------------------------
public class Dtocust {

   // Fields
   String custid;
   String cpw;
   String cname;
   String cphone;
   String caddress;
   String cindate;
   String coutdate;
   
   
   
   // Constructor
   public Dtocust() {
      // TODO Auto-generated constructor stub
   }

   public Dtocust(String custid, String cpw, String cname, String cphone, String caddress) {
      super();
      this.custid = custid;
      this.cpw = cpw;
      this.cname = cname;
      this.cphone = cphone;
      this.caddress = caddress;
   }

   //TEST

   public Dtocust(String cname) {
	super();
	this.cname = cname;
}

// Method
   public String getCustid() {
      return custid;
   }

   public void setCustid(String custid) {
      this.custid = custid;
   }

   public String getCpw() {
      return cpw;
   }

   public void setCpw(String cpw) {
      this.cpw = cpw;
   }

   public String getCname() {
      return cname;
   }

   public void setCname(String cname) {
      this.cname = cname;
   }

   public String getCphone() {
      return cphone;
   }

   public void setCphone(String cphone) {
      this.cphone = cphone;
   }

   public String getCaddress() {
      return caddress;
   }

   public void setCaddress(String caddress) {
      this.caddress = caddress;
   }

   public String getCindate() {
      return cindate;
   }

   public void setCindate(String cindate) {
      this.cindate = cindate;
   }

   public String getCoutdate() {
      return coutdate;
   }

   public void setCoutdate(String coutdate) {
      this.coutdate = coutdate;
   }
   
   

   
   
   
   
   
} // End