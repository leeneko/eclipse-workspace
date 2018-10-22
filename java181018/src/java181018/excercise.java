package java181018;

public class excercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// startValue부터 endValue까지 수의 약수들을 출력
		int startValue = 10;
		int endValue = 36;
		getDivisors(startValue, endValue);
	}

	private static void getDivisors(int startValue, int endValue) {
		// TODO Auto-generated method stub
		for (int i = startValue; i <= endValue; i++) {
			System.out.print(i + "의 약수 : ");
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					System.out.print(j + "\t");
				}
			}
			System.out.println();
		}
	}

}
