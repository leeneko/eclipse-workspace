package java181010;

public class BubbleSort {

	public static void main(String[] args) {
		// Bubble Sort (오름차순)
		int[] array = { 45, 7, 12, 82, 25 };
		int temp;

		for (int bubble = 1; bubble < array.length; bubble++) {
			for (int i = 0; i < array.length - bubble; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

//		Bubble Sort (내림차순)
//		int[] array = { 45, 7, 12, 82, 25 };
//		int temp;
//
//		for (int bubble = 1; bubble < array.length; bubble++) {
//			for (int i = 0; i < array.length - bubble; i++) {
//				if (array[i] > array[i + 1]) {
//					temp = array[i + 1];
//					array[i + 1] = array[i];
//					array[i] = temp;
//				}
//			}
//		}
//
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
	}

}
