package 이병진_개인실기;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		int sum = 0;
		int num1 = 10;
		int num2 = 1;
		
//		sum += input % 10;
//		sum += input % 100 / 10;
//		sum += input % 1000 / 100;
		
		while (true) {
			sum += input % num1 / num2;
			num1 *= 10;
			num2 *= 10;
			if (num2 > input) {
				break;
			}
		}
		System.out.print("합은 " + sum + "입니다.");
		sc.close();
	}

}
