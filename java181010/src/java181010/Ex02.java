package java181010;

public class Ex02 {

	public static void main(String[] args) {
		// 2차원 배열 복습 (for ~ each문)
		int[][] array =  new int[3][3];
		int num = 0;
		
//		System.out.println(array[0]);
//		System.out.println(array[1]);
//		System.out.println(array[2]);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				num += 10;
				array[i][j] = num;
			}
		}
		
		for (int[] i : array) {
//			System.out.println(i);
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
//		for(int i = 0; i < array.length; i++) {
//			for(int j = 0; j < array[i].length; j++) {
//				System.out.print(array[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

}
