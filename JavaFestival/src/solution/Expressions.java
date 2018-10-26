package solution;

import java.util.ArrayList;

public class Expressions {
	public int expressions(int input) {
		// input = 15;
		int count = 0;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 1; i <= input; i++) {
			array.add(i);
		}
		
//		for (int i = 0; i < array.size(); i++) {
//			System.out.print(array.get(i) + " ");
//		}
		
		// array = { 1, 2, 3, 4, ... , 14, 15 }
		// count at
		// 1+2+3+4+5 >>> 0, 1, 2, 3, 4
		// 4+5+6 >>> 3, 4, 5
		// 7+8 >>> 6, 7
		// 15 >> 14
		
		for (int i = 0; i < array.size(); i++) {
			int sum = 0;
			while (sum < input) {
				sum += array.get(i);
			}
			if (sum == input) {
				count++;
			}
		}
		
		return count;
	}
}
