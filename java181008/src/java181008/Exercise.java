package java181008;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][5];
		int num = 21;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = num++;
			}
		}
		
		// 21 22 23 24 25
		// 30 29 28 27 26
		// 31 32 33 34 35
		// 40 39 38 37 36
		// 41 42 43 44 45
		
		// 00 01 02 03 04
		// 14 13 12 11 10
		// 20 21 22 23 24
		// 34 33 32 31 30
		// 40 41 42 43 44
		
		for(int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				for(int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			} else {
				for(int j = 4; j >= 0; j--) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
