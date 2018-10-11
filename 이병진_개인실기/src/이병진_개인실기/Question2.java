package 이병진_개인실기;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= input; i++) {
			sum += i;
		}
		System.out.println("1~" + input + "까지 합은 " + sum + "입니다.");
		sc.close();
	}

}
