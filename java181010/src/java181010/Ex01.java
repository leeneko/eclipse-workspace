package java181010;

public class Ex01 {

	public static void main(String[] args) {
		// 2차원 배열 복습
		int[][] array =  new int[3][3];
		int num = 0;
		
//		System.out.println(array);
//		System.out.println(array[0]);
//		System.out.println(array[0][0]);
		
//		System.out.println(array.length);
//		System.out.println(array[1].length);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				num += 10;
				array[i][j] = num;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
