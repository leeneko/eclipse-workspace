import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InsertSystem IS = new InsertSystem();
		SelectSystem SS = new SelectSystem();
		
		while (true) {
			System.out.println("1.입력 2.조회 3.검색 4.종료");
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
				SS.select();
			} else if (choice == 3) {
				System.out.print("이름 : ");
				SS.select(sc.next());
			} else if (choice == 4) {
				break;
			}
		}
		sc.close();
	}
	
}
