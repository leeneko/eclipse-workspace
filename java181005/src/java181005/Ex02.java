package java181005;

import java.util.*;

public class Ex02 {

	public static void main(String[] args) {
		// String[] team = new String[5];
		// team[0] = "�輱��"; ...
		Scanner sc = new Scanner(System.in);
		String[] team = { "�輱��", "����", "���¿�", "�̺���", "������" };

		System.out.println("==���� �˻� ���α׷�==");
		System.out.print("�˻��� ���� �Է� : ");
		String input = sc.nextLine();

		for (int i = 0; i < team.length; i++) {
			if (input.equals(team[i])) {
				System.out.println(input + "���� " + (i + 1) + "��° �ε����� �����Ǿ� �ֽ��ϴ�.");
				break;
			} else if (i == team.length - 1) {
				System.out.println(input + "���� �������� �ʽ��ϴ�.");
			}
		}

		sc.close();
	}

}
