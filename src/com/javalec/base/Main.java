package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.Calc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//고석진 첫번째수정
		int getNum1 =0;
		int getNum2 =0;
		//고석진 수정2
		//임은빈 확인완
		
		System.out.println("첫번쨰 숫자를 입력하세요 :");
		getNum1 = scanner.nextInt();

		System.out.println("두번째 숫자를 입력하세요 :");
		getNum2 = scanner.nextInt();
		

		Calc calc = new Calc(getNum1, getNum2);

		
		//----------------빈생성자 또는 하나만받는생성자사용할때 테스트용.
		
		//		Calc calc1 = new Calc(getNum1);
//		
//		calc1.sum();
//		
//		System.out.println(calc1.sum());
		
		
		
		
		
		
	}

}
