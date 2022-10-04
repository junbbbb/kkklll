package com.javalec.dto;

public class Dtoorder {
	
	// field
	String orderid;
	String customer_custid;
	String product_proid;
	String oquantity;
	String odate;
	
	
	// con
	public Dtoorder() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Dtoorder(String orderid, String customer_custid, String product_proid, String oquantity, String odate) {
		super();
		this.orderid = orderid;
		this.customer_custid = customer_custid;
		this.product_proid = product_proid;
		this.oquantity = oquantity;
		this.odate = odate;
	}



	
	
	// method
	

	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
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


	public String getOquantity() {
		return oquantity;
	}


	public void setOquantity(String oquantity) {
		this.oquantity = oquantity;
	}


	public String getOdate() {
		return odate;
	}


	public void setOdate(String odate) {
		this.odate = odate;
	} 
	
	

	

}//END
