package student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		
		System.out.print("이름 : ");
		st.setName(sc.next());
		
		System.out.print("학번 : ");
		st.setStNum(sc.nextInt());

		System.out.print("자바 점수 : ");
		st.setJavaScore(sc.nextInt());
		
		System.out.print("웹 점수 : ");
		st.setWebScore(sc.nextInt());
		
		System.out.print("안드로이드 점수 : ");
		st.setAndroidScore(sc.nextInt());
		
		sc.close();
		
		System.out.println("이름 : " + st.getName());
		System.out.println("학번 : " + st.getStNum());
		System.out.println("자바 점수 : " + st.getJavaScore());
		System.out.println("웹 점수 : " + st.getWebScore());
		System.out.println("안드로이드 점수 : " + st.getAndroidScore());
		
	}

}
