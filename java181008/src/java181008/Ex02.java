package java181008;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int count = 0;
		for (int i : array) {
			count = i % 2 == 0 ? count + 1: count;
//			if(i % 2 == 0) {
//				count++;
//			}
		}
		System.out.println(count);
	}

}
