package java181011;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 9, 3, 2, 15, 32, 26 };
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾고자 하는 숫자 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 0; i < array.length; i++) {
			if (input == array[i]) {
				System.out.println("찾으시는 숫자는 " + i + "번째 인덱스에 있습니다.");
			}
		}
		sc.close();
	}

}
