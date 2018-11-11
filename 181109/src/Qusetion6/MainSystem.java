package Qusetion6;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("=================학점 관리 프로그램=================");
			System.out.print("[1]성적입력 [2]전체조회 [3]학생검색 [4]종료 >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("=============================================");
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("학번 : ");
				String num = sc.next();
				System.out.print("Java 점수 : ");
				int java = sc.nextInt();
				System.out.print("Web 점수 : ");
				int web = sc.nextInt();
				System.out.print("Android 점수 : ");
				int and = sc.nextInt();
				
				StudentVO vo = new StudentVO(name, num, java, web, and);
				
				dao.insert(vo);
			} else if (input == 2) {
				ArrayList<StudentVO> list = dao.select();
				System.out.println("======================전체 조회======================");
				System.out.println("이름\t학번\tJava\tWeb\tAndroid\t평균\t학점");
				for (StudentVO vo : list) {
					int avg = vo.getScoreJava() + vo.getScoreWeb() + vo.getScoreAndroid() / 3;
					String s;
					if (avg > 95) {
						s = "A+";
					} else if (avg > 85) {
						s = "B+";
					} else if (avg > 75) {
						s = "C+";
					} else {
						s = "F";
					}
					System.out.println(vo.getName() + "\t" + vo.getStuNumber() + "\t" + vo.getScoreJava() + "\t" + vo.getScoreWeb() + "\t" + vo.getScoreAndroid() + "\t" + avg + "\t" + s);
				}
			} else if (input == 3) {
				System.out.print("검색할 이름 입력 : ");
				ArrayList<StudentVO> list = dao.select(sc.next());
				System.out.println("======================전체 조회======================");
				System.out.println("이름\t학번\tJava\tWeb\tAndroid\t평균\t학점");
				for (StudentVO vo : list) {
					int avg = vo.getScoreJava() + vo.getScoreWeb() + vo.getScoreAndroid() / 3;
					String s;
					if (avg > 95) {
						s = "A+";
					} else if (avg > 85) {
						s = "B+";
					} else if (avg > 75) {
						s = "C+";
					} else {
						s = "F";
					}
					System.out.println(vo.getName() + "\t" + vo.getStuNumber() + "\t" + vo.getScoreJava() + "\t" + vo.getScoreWeb() + "\t" + vo.getScoreAndroid() + "\t" + avg + "\t" + s);
					System.out.println("===================================================");
					System.out.println("=====================성적그래프======================");
					System.out.println("\t\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
					System.out.print("Java[" + vo.getScoreJava() + "]:\t");
					for (int i = 10; i < vo.getScoreJava(); i+=10) {
						System.out.print("\t*");
					}
					System.out.println();
					System.out.print("Web[" + vo.getScoreWeb() + "]:\t");
					for (int i = 10; i < vo.getScoreWeb(); i+=10) {
						System.out.print("\t*");
					}
					System.out.println();
					System.out.print("Android[" + vo.getScoreAndroid() + "]:\t");
					for (int i = 10; i < vo.getScoreAndroid(); i+=10) {
						System.out.print("\t*");
					}
					System.out.println();
				}
			} else if (input == 4) {
				System.out.println("학점 관리 프로그램을 종료합니다.");
				break;
			}
		}
	}

}
