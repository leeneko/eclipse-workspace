package student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		
		int temp = 0;
		int input = 0;
		while (input != 3) {
			System.out.println("1.학생등록 2.학생정보확인 3.종료");
			input = sc.nextInt();
			
			if (input == 1) {
				list.add(null);
				System.out.println("======학생등록======");
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("학번 : ");
				int num = sc.nextInt();
				System.out.print("자바 점수 : ");
				int ja = sc.nextInt();
				System.out.print("웹 점수 : ");
				int we = sc.nextInt();
				System.out.print("안드로이드 점수 : ");
				int an = sc.nextInt();
				
				list.set(temp, new Student(name, num, ja, we, an));
				temp++;
			} else if (input == 2) {
				System.out.println("=====학생정보확인=====");
				System.out.print("학번 : ");
				int select = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getStNum() == select) {
						System.out.println(i+1 + " 이름 : " + list.get(i).getName());
						System.out.println(i+1 + " 학번 : " + list.get(i).getStNum());
						System.out.println(i+1 + " 자바 점수 : " + list.get(i).getJavaScore());
						System.out.println(i+1 + " 웹 점수 : " + list.get(i).getWebScore());
						System.out.println(i+1 + " 안드로이드 점수 : " + list.get(i).getAndroidScore());
					}
				}
//				for (int i = 0; i < list.length; i++) {
//					if (list[i] == null) {
//						break;
//					}
//					System.out.println(i+1 + " 이름 : " + list[i].getName());
//					System.out.println(i+1 + " 학번 : " + list[i].getStNum());
//					System.out.println(i+1 + " 자바 점수 : " + list[i].getJavaScore());
//					System.out.println(i+1 + " 웹 점수 : " + list[i].getWebScore());
//					System.out.println(i+1 + " 안드로이드 점수 : " + list[i].getAndroidScore());
//				}
			} else if (input == 3) {
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		sc.close();
//		System.out.println("이름 : " + st.getName());
//		System.out.println("학번 : " + st.getStNum());
//		System.out.println("자바 점수 : " + st.getJavaScore());
//		System.out.println("웹 점수 : " + st.getWebScore());
//		System.out.println("안드로이드 점수 : " + st.getAndroidScore());
	}

}
