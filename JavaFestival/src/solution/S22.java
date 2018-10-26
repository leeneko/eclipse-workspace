package solution;

public class S22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jumpCase(7));
	}
	
	public static int jumpCase(int i) {
		if (i <= 2) // 기존 피보나치 함수에서 리턴 범위 1 증가
			return i;
		else
			return jumpCase(i-2) + jumpCase(i-1);
	}
	
}
