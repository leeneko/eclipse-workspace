package solution;

import java.util.Scanner;

public class S20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // 입력 받은 정수 input에 저장
		System.out.println(collatzNumber(input)); // collatzNumber 함수 호출 및 출력
		sc.close();
	}
	
	private static int collatzNumber(int e) {
		int count = 0; // 결과 값 저장할 변수
		while(true) {
			if (e == 1) { // 결과가 1이 된 경우 break;
				break;
			} else if (count > 500) { // 500번 반복해도 1이 되지 않을 때 -1 반환
				count = -1;
				break;
			} else if (e % 2 == 0) { // 입력된 수가 짝수 일 때
				e /= 2;
				count++;
			} else { // 홀수 일 때
				e = (e * 3) + 1;
				count++;
			}
		}
		
		return count;
	}
}
