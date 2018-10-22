package solution;

import java.util.Scanner;

public class S20 {

	public static void main(String[] args) {
		// 입력된 수가 짝수라면 2로 나누고, 홀수라면 3을 곱하고 1을 더한 다음
		// 결과로 나온 수에 같은 작업을 1이 될 때까지 반복할 경우
		// 모든 수가 1이 됩니다.
		// 입력된 수가 6이라면 6 > 3 > 10 > 5 > 16 > 8 > 4 > 2 > 1
		// 8번 만에 1이 됩니다.
		// collatzNumber() 메소드를 만들어 입력된 수가 몇 번 만에 1이 되는지 반환해주세요
		// 단, 500번을 반복해도 1이 되지 않는다면 -1을 반환해 주세요.
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // 입력 받은 정수 input에 저장
		System.out.println(collatzNumber(input)); // collatzNumber 함수 호출 및 출력
		sc.close();
	}
	
	private static int collatzNumber(int e) {
		int output = 0; // 연산(반복) 회수 저장할 함수
		
		while(true) {
			if (e % 2 == 0) { // 짝수일 때 연산
				e /= 2;
			} else { // 홀수일 때 연산
				e = e * 3 + 1;
			}
			
			output++;
			if (e == 1) { // 입력받은 수가 1이 되었을 때 break;
				break;
			}
			if (output == 500) { // 500번 반복해도 1이 되지 않았을 때
				output = -1; // 결과값으로 -1 반환
				break;
			}
		}
		
		return output;
	}
}
