package java181011;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 9, 3, 2, 15, 32, 26 };
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ã���� �ϴ� ���� �Է� : ");
		int input = sc.nextInt();
		
		for (int i = 0; i < array.length; i++) {
			if (input == array[i]) {
				System.out.println("ã���ô� ���ڴ� " + i + "��° �ε����� �ֽ��ϴ�.");
			}
		}
		sc.close();
	}

}
