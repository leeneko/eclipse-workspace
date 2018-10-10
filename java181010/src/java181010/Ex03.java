package java181010;

import java.util.*;

public class Ex03 {

	public static void main(String[] args) {
		// 답		4	5	4	1	2
		// 입력한 값	@	@	@	@	@
		// 배점		10	20	30	20	20
		Scanner sc = new Scanner(System.in);
		int score = 0;
		
		int[][] array = new int[3][5];
		array[0][0] = 4;	array[0][1] = 5;	array[0][2] = 4;
		array[0][3] = 1;	array[0][4] = 2;
		
		array[2][0] = 10;	array[2][1] = 20;	array[2][2] = 30;
		array[2][3] = 20;	array[2][4] = 20;
		
//		for (int i = 0; i < array[0].length; i++) {
//			System.out.println(array[0][i]);
//		}
		
		for (int i = 0; i < array[1].length; i++) {
			System.out.print(i + 1 + "번째 답 >> ");
			array[1][i] = sc.nextInt();
		}
		
		for (int i = 0; i < array[0].length; i++) {
			if (array[0][i] == array[1][i]) {
				System.out.print("O\t");
				score += array[2][i];
			} else {
				System.out.print("X\t");
			}
		}
		System.out.println("\n총점 : " + score);
		
		sc.close();
	}
}
