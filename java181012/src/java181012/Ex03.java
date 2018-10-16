package java181012;

public class Ex03 {

	public static void main(String[] args) {
		addNum(10);
		addNum(10, 11);
		
		System.out.println(add(5, 7));
	}

	private static void addNum(int i) {
		System.out.println(i + 1);
	}

	private static void addNum(int i, int j) {
		System.out.println(i + j);
	}
	
	private static int add(int i, int j) {
		return i+j;
	}

}
