package java181005;

import java.util.*;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = { 1, 4, 3, 2, 1 };
		int[] input = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==채점하기==");
		System.out.println("답을 입력하세요");
		for (int i = 0; i < input.length; i++) {
			System.out.print(i + 1 + "번 답 >> ");
			input[i] = sc.nextInt();
		}

//		System.out.print("입력한 답은 : ");
//		for (int i = 0; i < input.length; i++) {
//			System.out.print(input[i] + " ");
//		}
		
		int score = 0;
		System.out.println("정답확인");
		for(int i = 0; i < input.length; i++) {
			if (result[i] == input[i]) {
				System.out.print("O ");
				score += 20;
			} else {
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + score);

		sc.close();
	}

}
