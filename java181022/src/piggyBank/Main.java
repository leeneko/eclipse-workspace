package piggyBank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PiggyBank my = new PiggyBank();

		while (true) {
			System.out.print("1.입금 2.출금 3.잔액조회 4.종료 >> ");
			int input = sc.nextInt();

			if (input == 1) {
				if(my.deposit(sc.nextInt())) {
					System.out.println("입금 후 잔액 : " + my.money);
				} else {
					System.out.println("잘못된 입력");
				}
			} else if (input == 2) {
				if(my.withdraw(sc.nextInt())) {
					System.out.println("출금 후 잔액 : " + my.money);
				} else {
					System.out.println("잔액 부족");
				}
			} else if (input == 3) {
				System.out.println("잔액 : " + my.showMoney());
			} else if (input == 4) {
				break;
			}
		}
		
		sc.close();
		
	}

}
