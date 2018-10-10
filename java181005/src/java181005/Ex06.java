package java181005;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] idArray = new String[3];
		String[] pwArray = new String[3];

		for (;;) {
			System.out.print("1.회원가입 2.로그인 3.종료 >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("===회원가입===");
				if (idArray[0] == null && pwArray[0] == null) {
					System.out.print("ID 입력 : ");
					idArray[0] = sc.next();
					System.out.print("PW 입력 : ");
					pwArray[0] = sc.next();
				} else if (idArray[1] == null && pwArray[1] == null) {
					System.out.print("ID 입력 : ");
					idArray[1] = sc.next();
					System.out.print("PW 입력 : ");
					pwArray[1] = sc.next();
				} else if (idArray[2] == null && pwArray[2] == null) {
					System.out.print("ID 입력 : ");
					idArray[2] = sc.next();
					System.out.print("PW 입력 : ");
					pwArray[2] = sc.next();
				}
			} else if (menu == 2) {
				String check = "로그인 실패";
				System.out.println("===로그인===");
				System.out.print("ID : ");
				String idInput = sc.next();
				System.out.print("PW : ");
				String pwInput = sc.next();
				for (int i = 0; i < idArray.length; i++) {
					if (idInput.equals(idArray[i]) && pwInput.equals(pwArray[i])) {
						check = "로그인 성공";
						break;
					}
				}
				System.out.println(check);
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				for (int i = 0; i < idArray.length; i++) {
					System.out.println("ID : " + idArray[i]);
					System.out.println("PW : " + pwArray[i]);
				}
				break;
			} else {
				System.out.println("정확한 숫자를 입력해주세요.");
			}
		}
		
		sc.close();
	}

}
