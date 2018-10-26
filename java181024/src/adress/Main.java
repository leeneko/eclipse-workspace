package adress;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		AddressController ac = new AddressController();

		AddressBookVO pbk1 = new AddressBookVO("박병관", 20, "010-4611-5278", "광주광역시광산구");
		ac.addList(pbk1);
		AddressBookVO pbk2 = new AddressBookVO("이병진", 25, "010-4322-1621", "광주광역시서구");
		ac.addList(pbk2);
		AddressBookVO pbk3 = new AddressBookVO("정승우", 26, "010-2411-6403", "도쿄");
		ac.addList(pbk3);
		AddressBookVO pbk4 = new AddressBookVO("박종진", 26, "010-3056-1182", "광주광역시");
		ac.addList(pbk4);
		AddressBookVO pbk5 = new AddressBookVO("달토끼", 421, "000-0000-0000", "MOON");
		ac.addList(pbk5);

		int input = 0;

		while (input != 6) {
			System.out.print("1.등록 2.열람 3.찾기 4.변경 5.삭제 6.종료");
			input = sc.nextInt();
			if (input == 1) {
				System.out.println("======등록======");
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("나이 : ");
				int age = sc.nextInt();
				System.out.print("번호 : ");
				String tel = sc.next();
				System.out.print("주소 : ");
				String address = sc.next();
				ac.addList(name, age, tel, address);
			} else if (input == 2) {
				System.out.println("======열람======");
				for (int i = 0; i < ac.length(); i++) {
					AddressBookVO vo = ac.getList(i);
					voPrint(vo);
				}
			} else if (input == 3) {
				System.out.println("======찾기======");
				System.out.print("이름 : ");
				String search_name = sc.next();
				
				AddressBookVO vo = ac.select(search_name);
				if (vo != null) {
					voPrint(vo);
				}
			} else if (input == 4) {
				System.out.println("======변경======");
				System.out.print("이름 : ");
				String search = sc.next();
				
				AddressBookVO vo = ac.select(search);
				if (vo != null) {
					System.out.println("아래의 주소록을 찾았습니다.");
					voPrint(vo);
					System.out.print("변경하실 이름 : ");
					vo.setName(sc.next());
					System.out.print("변경하실 나이 : ");
					vo.setAge(sc.nextInt());
					System.out.print("변경하실 번호 : ");
					vo.setTel(sc.next());
					System.out.print("변경하실 주소 : ");
					vo.setAddress(sc.next());
				} else {
					System.out.println("찾으시려는 주소록이 없습니다.");
				}
			} else if (input == 5) {
				System.out.println("======삭제======");
				System.out.print("삭제하려는 주소록의 이름 : ");
				ac.delete(sc.next());
			} else if (input == 6) {
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		
		sc.close();

	}

	private static void voPrint(AddressBookVO vo) {
		System.out.println("이름 : " + vo.getName());
		System.out.println("나이 : " + vo.getAge());
		System.out.println("번호 : " + vo.getTel());
		System.out.println("주소 : " + vo.getAddress());
	}

}
