package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.Calc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int getNum =0;
		int num1 =0;
		int num2 =0;
		
		Scanner scanner = new Scanner(System.in);
		
		//출력부
		System.out.println("1. 덧셈\n2. 뺄셈\n3. 곱셈\n4. 나눗셈 몫\n5. 나눗셈 나머지\n6. 나눗셈\n7. 종료");
		
		System.out.println(">>번호를 선택하세요 : ");
		getNum = scanner.nextInt();
		
		System.out.println("첫번째 숫자를 입력하세요 : ");
		num1 = scanner.nextInt();
		System.out.println("두번째 숫자를 입력하세요 : ");
		num2 = scanner.nextInt();
		
		Calc calc = new Calc(getNum, num1, num2);
		
	
		
		
		
		
		
	}

}
