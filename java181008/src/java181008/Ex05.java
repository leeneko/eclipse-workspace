package java181008;

public class Ex05 {

	public static void main(String[] args) {
		int[][] array = new int[2][2];
		array[0][0] = 10;
		array[0][1] = 20;
		array[1][0] = 30;
		array[1][1] = 40;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println(array[i][j]);
			}
		}
	}

}
