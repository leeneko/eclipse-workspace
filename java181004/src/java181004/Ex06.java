package java181004;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];

		input(sc, num); // �Է�

		int max = num[0];
		int min = num[0];
		int sum = 0;
		double avg = 0;

		
		System.out.print("�Էµ� ����: ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
			if (num[i] > max) {
				max = num[i];
			}
			if (min > num[i]) {
				min = num[i];
			}
			sum += num[i];
		}
		avg = sum / (double) num.length;

		System.out.println("\n�ְ� ����: " + max);
		System.out.println("���� ����: " + min);
		System.out.println("�հ�: " + sum);
		System.out.println("���: " + avg);

		sc.close();
	}

	private static void input(Scanner sc, int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(i + 1 + "��° �Է�>>");
			num[i] = sc.nextInt();
		}
	}
}