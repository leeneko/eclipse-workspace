package java181005;

import java.util.*;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = { 1, 4, 3, 2, 1 };
		int[] input = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==ä���ϱ�==");
		System.out.println("���� �Է��ϼ���");
		for (int i = 0; i < input.length; i++) {
			System.out.print(i + 1 + "�� �� >> ");
			input[i] = sc.nextInt();
		}

//		System.out.print("�Է��� ���� : ");
//		for (int i = 0; i < input.length; i++) {
//			System.out.print(input[i] + " ");
//		}
		
		int score = 0;
		System.out.println("����Ȯ��");
		for(int i = 0; i < input.length; i++) {
			if (result[i] == input[i]) {
				System.out.print("O ");
				score += 20;
			} else {
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + score);

		sc.close();
	}

}