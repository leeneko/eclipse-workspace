package java181018;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산기호 입력 (+, -, *, /) : ");
		String opr = sc.next();
		sc.close();
		
		double result = cal(num1, num2, opr);
		System.out.println(result);
	}

	private static double cal(int num1, int num2, String opr) {
		// TODO Auto-generated method stub
		int temp = 0;
		
		if (opr.equals("+")) {
			temp = num1 + num2;
		} else if (opr.equals("-")) {
			temp = num1 - num2;
		} else if (opr.equals("*")) {
			temp = num1 * num2;
		} else if (opr.equals("/")) {
			temp = num1 / num2;
		} else {
			System.out.println("연산기호를 잘못 입력하셨습니다.");
		}
		
		return temp;
	}

}
