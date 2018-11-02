package java181101;

import java.util.ArrayList;

public class Regular {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new RegularEmployee("SMHRD001", "이영호", 4000, 400));
		list.add(new TempEmployee("SMHRD002", "홍길동", 3500));
		list.add(new PartTimeEmployee("SMHRD003", "임성훈", 8, 10));
		
		for (Employee employee : list) {
			System.out.println((employee).print());
			System.out.println((employee).getMoneyPay() + "만원");
		}
	}
	
}
