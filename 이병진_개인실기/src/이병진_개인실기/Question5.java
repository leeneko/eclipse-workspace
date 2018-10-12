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
		int cnt = 1;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if ( i % 2 == 0 ) {
					array[i][j] = cnt;
				} else {
					array[i][array[i].length-1-j] = cnt;
				}
				cnt++;
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
