package solution;

import java.util.Scanner;

public class S19 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		System.out.println(isHarshad(input));
		sc.close();
	}

	private static boolean isHarshad(int in) {
		int sum = 0; // 자릿수 합
		// temp : 계산용 input 값
		for (int temp = in ; temp > 0; temp /= 10) {
			sum += temp % 10; // 자릿수 합 변수에 계산용 input 값의 1의 자리 수 누적
		} // 반복할 때마다 1의 자리 수 제거
		
		if (in % sum == 0) // 입력 값을 자릿수 합으로 나눴을 때 0이면
			return true;
		else // 0이 아니면
			return false;
		
	}
}
