package java181101;

public abstract class Employee {
	
	String empno; // 사번
	String name; // 이름
	int pay; // 연봉
	
	public abstract int getMoneyPay();
	
	public String print() {
//		return "RegularEmployee [empno=" + empno + ", name=" + name + ", pay=" + pay + ", bonus=" + bonus + "]";
		return empno + " : " + name + " : " + pay;
	}

}
