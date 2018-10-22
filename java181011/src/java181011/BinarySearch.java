package java181011;

public class BinarySearch {

	public static void main(String[] args) {
		// Binary search (이진 탐색)
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int search_num = 2;

		int minIndex = 0;
		int maxIndex = array.length - 1;
		int index = (minIndex + maxIndex) / 2; // 중간 인덱스 : 4

		while (true) {
			if (search_num > array[index]) {
				minIndex = ++index;
				index = (minIndex + maxIndex) / 2;
			} else if (search_num == array[index]) {
				System.out.println(index + "인덱스입니다.");
				break;
			} else {
				maxIndex = --index;
				index = (minIndex + maxIndex) / 2;
			}
		}

	}

}
