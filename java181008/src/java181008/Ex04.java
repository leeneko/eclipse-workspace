package java181008;

public class Ex04 {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 34 55 ... �Ǻ���ġ ����
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		
//		for (int i = 0; i < 4; i++) {
//			num3 = num1 + num2;
//			System.out.print(num1 + " ");
//			System.out.print(num2 + " ");
//			System.out.print(num3 + " ");
//			num1 = num2 + num3;
//			num2 = num3 + num1;
//		}
		
		System.out.print(num1 + " ");
		System.out.print(num2 + " ");
		for (int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			System.out.print(num3 + " ");
			num1 = num2;
			num2 = num3;
		}

	}

}
