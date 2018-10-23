package piggyBank;

public class PiggyBank {
	int money;
	
	boolean deposit(int i) { // 입금
		if (i < 0) {
			return false;
		} else {
			money += i;
			return true;
		}
	}
	
	boolean withdraw(int i) { // 출금
		if (money < i) {
			return false;
		} else {
			money -= i;
			return true;
		}
	}
	
	int showMoney() {
		return money;
	}

}
