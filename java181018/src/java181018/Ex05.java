package java181018;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 11;
		int num2 = 5;
		int result = close10(num1, num2);
		System.out.println("10에 가까운 수 : " + result);
	}

	private static int close10(int num1, int num2) {
		// TODO Auto-generated method stub
		int temp = 0;
		int temp1 = 10 - num1;
		int temp2 = 10 - num2;
		
		if (temp1 < 0) {
			temp1 *= -1;
		}
		if (temp2 < 0) {
			temp2 *= -1;
		}
		
		if (temp1 > temp2) {
			temp = num2;
		} else if (temp2 > temp1) {
			temp = num1;
		}
		
		return temp;
	}

}
