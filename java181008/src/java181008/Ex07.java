package java181008;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][5];
		int num = 21;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = num++;
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[j][i] + "\t");
			}
			System.out.println();
		}
	}
}
