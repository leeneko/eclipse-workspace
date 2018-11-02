package java181101;

public class PartTimeEmployee extends Employee {

	private int workDay; // 일 수
	
	public PartTimeEmployee() {}
	public PartTimeEmployee(String empno, String name, int pay, int workDay) {
		super();
		this.empno = empno;
		this.name = name;
		this.pay = pay;
		this.workDay = workDay;
	}
	public int getMoneyPay() {
		return pay * workDay;
	}
}
