package java181008;

public class Ex06 {
	public static void main(String[] args) {
		int[][] array = new int[5][5];
		int num = 21;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = num++;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
