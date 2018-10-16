package solution;

import java.util.Scanner;

public class S18 {

	public static void main(String[] args) {
		// 문자열을 입력받아 알파벳 순서대로 정렬하여 반환하는 메소드를 구현하시오.
		// 단, 대소문자는 구분한다.
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		System.out.println(reverseStr(input));
		sc.close();
	}
	
	private static String reverseStr(String s) {
		String output = "";
		char[] charArray = s.toCharArray();
		char temp;
		
		// 오름차순 (bubble sort)
		// A~Z : 65~90, a~z : 97~122
		for (int i = 1; i < charArray.length; i++) {
			for (int j = 0; j < charArray.length - i; j++) {
				if (charArray[j] > charArray[j+1]) {
					temp = charArray[j+1];
					charArray[j+1] = charArray[j];
					charArray[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < charArray.length; i++) {
			output += charArray[i];
		}
		
		return output;
	}

}
