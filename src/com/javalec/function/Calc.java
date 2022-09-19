package com.javalec.function;

public class Calc {
	//Field
	int getNum = 0;
	int num1, num2;
	
	public Calc() {
	
	}
	
	
	
	public Calc(int getNum, int num1, int num2) {
		super();
		this.getNum = getNum;
		this.num1 = num1;
		this.num2 = num2;
		
		addition();
		subtraction();
		multiplication();
		quota();
		rest();
		division();
	}



	public void addition() {
		if(getNum == 1) {
			System.out.println("덧셈 결과는 " + (num1+num2)+ "입니다.");
		}
	}
	
	public void subtraction() {
		if(getNum == 2) {
			System.out.println("뺄셈 결과는 " + (num1-num2)+ "입니다.");
		}
	}
	
	public void multiplication() {
		if(getNum == 3) {
			System.out.println("곱셈 결과는 " + (num1*num2)+ "입니다.");
		}
	}
	public void quota() {
		if(getNum == 4) {
			System.out.println("나눗셈 몫은 " + (num1/num2)+ "입니다.");
		}
	}
	public void rest() {
		if(getNum == 5) {
			System.out.println("나눗셈 나머지는 " + (num1%num2)+ "입니다.");
		}
	}
	public void	division() {
		if(getNum == 6) {
			System.out.println("나눗셈 결과는 " + ((double)num1/num2)+ "입니다.");
		}
	}
	
	
	
	
	
	
	
	
}
