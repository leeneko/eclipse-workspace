package java181018;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int base = 10;
		int n = 2;
		int result = powerN(base, n);
		System.out.println("결과 확인 " + result);
	}

	private static int powerN(int base, int n) {
		// TODO Auto-generated method stub
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= base;
		}
		return result;
	}

}
