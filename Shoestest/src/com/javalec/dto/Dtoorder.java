package com.javalec.dto;

public class Dtoorder {
	
	// field
	int orderid;
	String customer_custid;
	String product_proid;
	int oquantity;
	String odate;
	
	String proid;
	String pname;
	String pbrand;
	int pprice;
	int psize;
	String pcolor;
	int pinvenquantity;
	String preceiptdate;
	
	String custid;
	String cname;
	String cpw;
	String cphone;
	String caddress;
	
	
	// con
	public Dtoorder() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Dtoorder(int orderid, String customer_custid, String product_proid, int oquantity, String odate) {
		super();
		this.orderid = orderid;
		this.customer_custid = customer_custid;
		this.product_proid = product_proid;
		this.oquantity = oquantity;
		this.odate = odate;
	}

	
	
	
	
	// M


	public Dtoorder(int orderid, String product_proid, int oquantity, String odate, String pname, String pbrand,
			int pprice, int psize, String pcolor, String cname) {
		super();
		this.orderid = orderid;
		this.product_proid = product_proid;
		this.oquantity = oquantity;
		this.odate = odate;
		this.pname = pname;
		this.pbrand = pbrand;
		this.pprice = pprice;
		this.psize = psize;
		this.pcolor = pcolor;
		this.cname = cname;
	}




	public int getOrderid() {
		return orderid;
	}




	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}




	public String getCustomer_custid() {
		return customer_custid;
	}




	public void setCustomer_custid(String customer_custid) {
		this.customer_custid = customer_custid;
	}




	public String getProduct_proid() {
		return product_proid;
	}




	public void setProduct_proid(String product_proid) {
		this.product_proid = product_proid;
	}




	public int getOquantity() {
		return oquantity;
	}




	public void setOquantity(int oquantity) {
		this.oquantity = oquantity;
	}




	public String getOdate() {
		return odate;
	}




	public void setOdate(String odate) {
		this.odate = odate;
	}




	public String getProid() {
		return proid;
	}




	public void setProid(String proid) {
		this.proid = proid;
	}




	public String getPname() {
		return pname;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public String getPbrand() {
		return pbrand;
	}




	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}




	public int getPprice() {
		return pprice;
	}




	public void setPprice(int pprice) {
		this.pprice = pprice;
	}




	public int getPsize() {
		return psize;
	}




	public void setPsize(int psize) {
		this.psize = psize;
	}




	public String getPcolor() {
		return pcolor;
	}




	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}




	public int getPinvenquantity() {
		return pinvenquantity;
	}




	public void setPinvenquantity(int pinvenquantity) {
		this.pinvenquantity = pinvenquantity;
	}




	public String getPreceiptdate() {
		return preceiptdate;
	}




	public void setPreceiptdate(String preceiptdate) {
		this.preceiptdate = preceiptdate;
	}




	public String getCustid() {
		return custid;
	}




	public void setCustid(String custid) {
		this.custid = custid;
	}




	public String getCname() {
		return cname;
	}




	public void setCname(String cname) {
		this.cname = cname;
	}




	public String getCpw() {
		return cpw;
	}




	public void setCpw(String cpw) {
		this.cpw = cpw;
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



	

	

}//END
