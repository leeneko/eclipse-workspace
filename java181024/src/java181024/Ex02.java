package java181024;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("이병진 : 010-4322-1621");
		
		int input = 0;
		
		while (input != 4) {
			System.out.print("1.등록 2.전체검색 3.삭제 4.종료 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 개행문자(enter) 삭제(delete)
			if (input == 1) {
				System.out.print("이름과 전화번호를 입력 (예:" + list.get(0) + ") : ");
				String inputString = sc.nextLine();
				list.add(inputString);
			} else if (input == 2) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(i+1 + " " + list.get(i));
				}
			} else if (input == 3) {
				System.out.print("삭제할 이름 입력 : ");
				String name = sc.next();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(name)) {
						list.remove(i);
					}
				}
//				for (int i = 0; i < list.size(); i++) {
//					if (name.equals(list.get(i).substring(0, name.length()))) {
//						list.remove(i);
//					}
//				}
			} else {
				System.out.println("잘못입력해주셨습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

}
