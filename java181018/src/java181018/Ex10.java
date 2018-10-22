package java181018;

public class Ex10 {
	public static void main(String[] args) {
		// 메소드 오버로딩
		// 파라미터 값의 개수가 다르거나,
		// 파라미터 값의 자료형(data type)이 달라서
		// 부르는 메소드가 달라지는 것을 말한다.
		
		System.out.println(plusNum2(1, 2));
		System.out.println(plusNum3(1, 2, 3));
		System.out.println(plusNum4(1, 2, 3, 4));
	}

	private static int plusNum4(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return i + j + k + l;
	}

	private static int plusNum3(int i, int j, int k) {
		// TODO Auto-generated method stub
		return i + j + k;
	}

	private static int plusNum2(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}
}
