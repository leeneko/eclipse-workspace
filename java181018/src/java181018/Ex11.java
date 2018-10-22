package java181018;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		
		print100(num1);
		print100(num1, num2);
		print100(num1, num2, num3);
	}

	private static void print100(int num1, int num2, int num3) {
		// TODO Auto-generated method stub
		System.out.println(100 - num1 - num2 - num3);
	}

	private static void print100(int num1, int num2) {
		// TODO Auto-generated method stub
		System.out.println(100 - num1 - num2);
	}

	private static void print100(int num1) {
		// TODO Auto-generated method stub
		System.out.println(100 - num1);
	}

}
