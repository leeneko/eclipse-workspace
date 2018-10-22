package java181018;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDivisor(10);
		getDivisor(16);
		getDivisor(24);
	}

	private static void getDivisor(int e) {
		// TODO Auto-generated method stub
		System.out.print(e + "의 약수 : ");
		for (int i = 1; i <= e; i++) {
			if (e % i == 0) {
				System.out.print(i + "\t");
			}
		}
		System.out.println();
	}

}
