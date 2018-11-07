
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InsertSystem IS = new InsertSystem();
		SelectSystem SS = new SelectSystem();
		SelectAllSystem SAS = new SelectAllSystem();
		
		while (true) {
			System.out.print("1.입력 2.조회 3.검색 4.종료 >> ");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("나이 : ");
				int age = sc.nextInt();
				System.out.print("전화번호 : ");
				String phone = sc.next();
				
				IS.insert(name, age, phone);
			} else if (choice == 2) {
				ArrayList<VO> list = SAS.select();
				print(list);
			} else if (choice == 3) {
				System.out.print("검색할 이름 : ");
				ArrayList<VO> list = SS.select(sc.next());
				print(list);
			} else if (choice == 4) {
				break;
			}
		}
		sc.close();
	}

	private static void print(ArrayList<VO> list) {
		System.out.println("이름\t나이\t전화번호");
		System.out.println("========================");
		for (VO vo2 : list) {
			System.out.print(vo2.getName() + "\t");
			System.out.print(vo2.getAge() + "\t");
			System.out.println(vo2.getPhone());
		}
	}
	
}
