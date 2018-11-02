package java181101;

public class RegularEmployee extends Employee {

	int bonus; // 보너스
	
	public RegularEmployee() {}
	public RegularEmployee(String empno, String name, int pay, int bonus) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
		this.bonus = bonus;
	}
	public int getMoneyPay() {
		return (pay + bonus) / 12;
	}

}
