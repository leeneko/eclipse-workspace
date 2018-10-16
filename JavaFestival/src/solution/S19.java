package solution;

import java.util.Scanner;

public class S19 {

	public static void main(String[] args) {
		// 하샤드 수
		// 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야합니다.
		// 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
		// isHarshad 메소드는 양의 정수 n을 매개변수로 입력받습니다.
		// 이 n이 하샤드 수인지 아닌지 판단하는 함수를 완성하세요.
		// 예를 들어 n이 10, 12, 18이면 True, 11, 13이면 False를 리턴
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		System.out.println(isHarshad(input));
		sc.close();
	}

	private static boolean isHarshad(int in) {
		boolean bool = false;
		int sum = 0;
		System.out.println(in);
		// 각 자릿 수의 합 구하기
		while(in != 0) {
			sum += in%10;
			in /= 10;
		}
		int temp = in % sum;
		// 합으로 수가 나누어 떨어지는지
		if (temp == 0) {
			bool = true;
		}
		
		return bool;
	}
}
