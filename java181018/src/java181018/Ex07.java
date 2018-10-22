package java181018;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 3;
		
		boolean result = isDivide(num1, num2);
		System.out.println("결과 확인 : " + result);
	}

	private static boolean isDivide(int num1, int num2) {
		boolean result = false;
		
		if (num1 % num2 == 0) {
			result = true;
		}
		
		return result;
	}

}
