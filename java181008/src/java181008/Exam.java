package java181008;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][5];
		int cnt = 21;
		int num = 30;

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < array.length; i++) {
				array[k][i] = cnt + (k * 5);
				cnt++;
				System.out.print(array[k][i] + " ");
			}
			System.out.println();
			for (int i = 0; i < array.length; i++) {
				if(k==2) {
					break;
				}
				array[k + 1][i] = num + (k * 15);
				num--;
				System.out.print(array[k + 1][i] + " ");
			}
			System.out.println();
		}
	}

}
