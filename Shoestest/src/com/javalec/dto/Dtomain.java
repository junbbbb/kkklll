package com.javalec.dto;

public class Dtomain {
	// Field
	String proid;
	String pname;
	String pbrand;
	int pprice;
	int psize;
	String pcolor;
	int pinvenquantity;
	String preceiptdate;
	
	public Dtomain() {
		// TODO Auto-generated constructor stub
	}
	

	public Dtomain(String proid, String pname, String pbrand, int pprice, int psize, String pcolor, int pinvenquantity) {
		super();
		this.proid = proid;
		this.pname = pname;
		this.pbrand = pbrand;
		this.pprice = pprice;
		this.psize = psize;
		this.pcolor = pcolor;
		this.pinvenquantity = pinvenquantity;
	}
	
// 데이터 추출용	
	public Dtomain(String pname, String pbrand, int pprice, int psize, String pcolor, int pinvenquantity) {
		super();
		this.pname = pname;
		this.pbrand = pbrand;
		this.pprice = pprice;
		this.psize = psize;
		this.pcolor = pcolor;
		this.pinvenquantity = pinvenquantity;
	}

	// 검색 추출용
	
	public Dtomain(String pname, String pbrand, int psize, String pcolor) {
		super();
		this.pname = pname;
		this.pbrand = pbrand;
		this.psize = psize;
		this.pcolor = pcolor;
	}
	

	//-Method-


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

	

}//END
