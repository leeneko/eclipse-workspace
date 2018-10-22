package java181010;

public class SelectionSort {

	public static void main(String[] args) {
		// selection sort
		int[] array = { 98, 7, 70, 13, 24 };

		int temp;
		int min;

		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
