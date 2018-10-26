package solution;

import java.util.Scanner;

public class S24 {

	public static void main(String[] args) {
		// 10진수 입력 받아 2진수로 변환하여 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력>> ");
		int n = sc.nextInt();
		sc.close();

		String temp = Integer.toBinaryString(n);
		
		System.out.println(temp);
	}

}
