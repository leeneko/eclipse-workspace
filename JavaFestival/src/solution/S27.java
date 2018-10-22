package solution;

public class S27 {

	public static void main(String[] args) {
		// 두개의 배열 A와 B를 합병 후 오름차순으로 정렬하여 반환하는 mergeArray 메소드를 완성하시오
		int A[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
		int B[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		int Merge[] = mergeArray(A, B);
		
		//출력
		System.out.print("Merge : [");
		for (int i = 0; i < Merge.length; i++) {
			System.out.print(Merge[i]);
			if (i == Merge.length - 1) {
				break;
			}
			System.out.print(",");
		}
		System.out.println("]");
	}

	private static int[] mergeArray(int[] a, int[] b) {
		int[] array = new int[a.length + b.length]; 
		
		// 병합
		for (int i = 0; i < array.length; i++) {
			if (i < a.length) {
				array[i] = a[i];
			} else {
				array[i] = b[i-a.length];
			}
		}
		
		// selection sort
		int min, temp;
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
		
		return array;
	}
	
	
}
