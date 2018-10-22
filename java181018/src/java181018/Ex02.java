package java181018;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 20;
		
		int result = plus(num1, num2);
		System.out.println(result);
		int result2 = mull(num1, num2);
		System.out.println(result2);
	}

	private static int mull(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 * num2;
		return result;
	}

	private static int plus(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 + num2;
		return result;
	}

}
