package pokemon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		pokemonCont pc = new pokemonCont();

		int user_choice = 0;
		while (user_choice != 5) {
			System.out.println("1.등록 2.전체조회 3.상세조회 4.삭제 5.종료 >> ");
			user_choice = sc.nextInt();
			
			if(user_choice == 1) {
				System.out.print("번호 : ");
				int num = sc.nextInt();
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("타입 : ");
				String type = sc.next();
				System.out.print("신장 : ");
				int height = sc.nextInt();
				System.out.print("몸무게 : ");
				int weight = sc.nextInt();
				System.out.print("성별");
				String gender = sc.next();
				
				pokemonVO vo = new pokemonVO(num, name, type, height, weight, gender);
				pc.list.add(vo);
			} else if(user_choice == 2) {
				for(int i = 0; i < pc.size(); i++) {
					System.out.print(pc);
				}
			} else if(user_choice == 3) {
				
			} else if(user_choice == 4) {
				
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		System.out.println("종료되었습니다.");
		sc.close();
	}

}
