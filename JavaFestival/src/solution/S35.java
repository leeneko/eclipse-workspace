package solution;

import java.util.Random;

public class S35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("배열에 있는 값");
		Random r = new Random();
		
		int max = 8;
		int[][] array = new int[max][max];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = r.nextInt(99) + 1;
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
		result(array);
	}

	private static void result(int[][] array) {
		// 최대값 >> num
		// 행 >> i    열 >> j
		int max = 0;
		int tempI = 0;
		int tempJ = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
					tempI = i;
					tempJ = j;
				}
			}
		}
		tempI++;
		tempJ++;
		
		System.out.println("최대값 >> " + max);
		System.out.println("행 >> " + tempI + "\t열 >> " + tempJ);
	}

}
