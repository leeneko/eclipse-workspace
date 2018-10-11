package java181010;

public class Star {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 0; i >= k; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
