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
		multiplication();
		quota();
		rest();
	}



	public void addition() {
        if(getNum==1) {
        	System.out.println("덧셈 결과는 " + (num1+num2)+ "입니다.");
        	}
	}
	
	public void multiplication() {
		{
			System.out.println("곱셈 결과는 " + (num1*num2)+ "입니다.");
		}
	}
	
	public void quota() {
		{
			System.out.println("나눗셈 몫은 " + (num1/num2)+ "입니다.");
		}
	}
	
	public void rest() {
		{
			System.out.println("나눗셈 나머지는 " + (num1%num2)+ "입니다.");
		}
	}
	
	
	
}
