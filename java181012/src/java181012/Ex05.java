package java181012;

public class Ex05 {

	public static void main(String[] args) {
		boolean check = checkNum(10);
		System.out.println(check);
	}

	private static boolean checkNum(int i) {
		if (i >= 10) {
			return true;
		} else {
			return false;
		}
	}

}
