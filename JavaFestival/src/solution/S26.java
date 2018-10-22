package solution;

import java.util.Scanner;

public class S26 {

	public static void main(String[] args) {
		// 5개의 정수를 입력 받아 오름차순 선택정렬
		int[] input = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < input.length; i++) {
			System.out.print(i+1 + "번째 수 입력 : ");
			input[i] = sc.nextInt();
		}
		sc.close();
		
		// 선택정렬
		// for i = 0 to n:
		//		a[i]부터 a[n - 1]까지 차례로 비교하여 가장 작은 값이 a[j]에 있다고 하자
		//		a[i]와 a[j]의 값을 서로 맞바꾼다.
		int min, temp;
		
		for (int i = 0; i < input.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[min]) {
					min = j;
				}
			}
			temp = input[min];
			input[min] = input[i];
			input[i] = temp;
		}
		
		//출력
		System.out.println("정렬 후");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
