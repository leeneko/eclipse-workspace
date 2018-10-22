package solution;

import java.util.Scanner;

public class S30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		System.out.print("첫자리 0을 제외한 숫자를 입력해주세요 >> ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		sc.close();
		
		// 0 - 6개
		// 1 - 2개
		// 2 - 5개
		// 3 - 5개
		// 4 - 4개
		// 5 - 5개
		// 6 - 6개
		// 7 - 3개
		// 8 - 7개
		// 9 - 6개
		
		int cnt = 0;
		// input = 12345
		// input % 10 = 5
		// input /= 10
		while (true) {
			int temp = input % 10;
			if (temp == 0 || temp == 6 || temp == 9) {
				cnt += 6;
			} else if (temp == 1) {
				cnt += 2;
			} else if (temp == 2 || temp == 3 || temp == 5) {
				cnt += 5;
			} else if (temp == 4) {
				cnt += 4;
			} else if (temp == 7) {
				cnt += 3;
			} else if (temp == 8) {
				cnt += 7;
			}
			input /= 10;
			if (input == 0) {
				break;
			}
		}
		
		System.out.println("대시('-')의 총 합 >> " + cnt);
	}

}
