package 이병진_개인실기;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][];
		array[0] = new int[1];
		array[1] = new int[2];
		array[2] = new int[3];
		array[3] = new int[4];
		array[4] = new int[5];
		int num = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = ++num;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
