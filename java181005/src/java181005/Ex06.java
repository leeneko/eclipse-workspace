package java181005;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] idArray = new String[3];
		String[] pwArray = new String[3];

		for (;;) {
			System.out.print("1.ȸ������ 2.�α��� 3.���� >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("===ȸ������===");
				if (idArray[0] == null && pwArray[0] == null) {
					System.out.print("ID �Է� : ");
					idArray[0] = sc.next();
					System.out.print("PW �Է� : ");
					pwArray[0] = sc.next();
				} else if (idArray[1] == null && pwArray[1] == null) {
					System.out.print("ID �Է� : ");
					idArray[1] = sc.next();
					System.out.print("PW �Է� : ");
					pwArray[1] = sc.next();
				} else if (idArray[2] == null && pwArray[2] == null) {
					System.out.print("ID �Է� : ");
					idArray[2] = sc.next();
					System.out.print("PW �Է� : ");
					pwArray[2] = sc.next();
				}
			} else if (menu == 2) {
				String check = "�α��� ����";
				System.out.println("===�α���===");
				System.out.print("ID : ");
				String idInput = sc.next();
				System.out.print("PW : ");
				String pwInput = sc.next();
				for (int i = 0; i < idArray.length; i++) {
					if (idInput.equals(idArray[i]) && pwInput.equals(pwArray[i])) {
						check = "�α��� ����";
						break;
					}
				}
				System.out.println(check);
			} else if (menu == 3) {
				System.out.println("���α׷��� �����մϴ�.");
				for (int i = 0; i < idArray.length; i++) {
					System.out.println("ID : " + idArray[i]);
					System.out.println("PW : " + pwArray[i]);
				}
				break;
			} else {
				System.out.println("��Ȯ�� ���ڸ� �Է����ּ���.");
			}
		}
		
		sc.close();
	}

}