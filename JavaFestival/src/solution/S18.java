package solution;

import java.util.Arrays;

public class S18 {

	public static void main(String[] args) {
		System.out.println(reverseStr("ZAbcdVefEg"));
	}
	
	public static String reverseStr(String s) {
		String result = ""; // 반환할 결과 값
		
		char[] array = s.toCharArray(); // 정렬을 위해 문자 배열로 분할
		Arrays.sort(array); // 정렬
		
		// 정렬된 char형 배열을 result에 누적
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		
		return result;
	}

}
