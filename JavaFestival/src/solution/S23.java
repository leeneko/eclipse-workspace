package solution;

import java.util.Scanner;

public class S23 {

	public static void main(String[] args) {
		// 소인수분해 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.print("소인수분해 할 수를 입력하세요. : ");
		int input = sc.nextInt();
		sc.close();
		System.out.print(input + " = ");
		int div = 2; // 소인수 분해할 수 최솟값 2
		
		while (true) {
			if (input % div == 0) {
				System.out.print(div);
				input /= div;
				if (input == 1) {
					// 수가 1이 된 경우 소인수 분해가 더이상 안되니 종료
					break;
				}
				System.out.print("*");
				div = 2; // 소인수 분해가 되면 소인수 분해할 값을 2로 초기화 
			} else {
				div++; // 소인수 분해가 안되서 소인수 분해할 수를 1증가
			}
			
		}

	}

}
