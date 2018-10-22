package java181018;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 24;
		int result = LargerNumbers(num1, num2);
		System.out.println("큰 수 확인 : " + result);
	}

	private static int LargerNumbers(int num1, int num2) {
		// TODO Auto-generated method stub
		int temp = 0;
		
		if (num1 > num2) {
			temp = num1;
		} else if (num1 == num2) {
			temp = num1;
		}
		
		return temp;
	}

}
