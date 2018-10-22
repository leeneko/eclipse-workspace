package solution;

import java.util.Scanner;

public class S24 {

	public static void main(String[] args) {
		// 10진수 입력 받아 2진수로 변환하여 출력
		System.out.print("숫자 입력>> ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // input = 10
		sc.close();
		// 2진수 자릿수 구하기
		int cnt = 0; // 2진수 자릿수
		int num = 2; // 자리수 구하기 위한 수
		while (true) {
			if (input > num) {
				num *= 2;
				cnt++;
			} else {
				break;
			}
		}
		
		num = (int) Math.pow(2, cnt);
		while (true) {
			if (input / num > 0) {
				System.out.print("1 ");
				input -= num;
			} else {
				System.out.print("0 ");
			}
			num /= 2;
			if (num == 0) {
				break;
			}
		}
	}

}
