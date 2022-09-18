package com.javalec.function;

public class Calc {
	int num1 =0;
	int num2 =0;
	int divMok=0,divNam=0;
	
	
//	public Calc() {
//		// TODO Auto-generated constructor stub
//	}//num하나도몰라도 넌 calc 오브젝을만들수가있어 나중에주던지
//	
//	public Calc(int num1) {
//		super();
//		this.num1 = num1;
//		// TODO Auto-generated constructor stub
//	}//넌 일단 숫자하나만알아도 사용가능해 ㅇ

	public Calc(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		
		System.out.println(">>덧셈결과 :"+sum());
		System.out.println(">>뺄셈결과 :"+sub());
		System.out.println(">>곱셈결과 :"+multi());
		System.out.println(">>나눗셈 몫 :"+div());
		
		
	}//완성형
	
	public int sum() {//영혁이의 첫번째 수정

		 return num1+num2;
	}
	
	public int sub() {
		return num1 - num2;
	}
	
	public int multi() {
		return num1*num2;
	}
//	public int div() {
//		
//		divMok = num1/num2;
//		divNam = num1-(num2*divMok);
//		return divMok;
//		
//	}
	public int div() {
		
		return num1/num2;
			
	}
	
	
	//------------------get할수잇는 메소드만들기(만약 하나만받을 수 있는 상태라다면)
	
	
	
}
