package java181008;

public class Ex08 {

	public static void main(String[] args) {
		// �������� �迭(�Ʒ��� ���� �ּҿ� ũ�⸦ ���� �迭)
		// 00
		// 10 11
		// 20 21 22
		// 30 31 32 33
		
		int[][] array = new int[4][];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[i+1];
		}
		
		int num = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = num++;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}