package java181018;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		int result = getAbsoluteValue(num1, num2);
		System.out.println("결과 확인 : " + result);
	}

	private static int getAbsoluteValue(int num1, int num2) {
		// TODO Auto-generated method stub
		int temp = num1 - num2;
		
		if (temp < 0) {
			temp *= -1;
		}
		return temp;
	}

}
