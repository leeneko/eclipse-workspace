package solution;

import java.util.Scanner;

public class S14 {

	public static void main(String[] args) {
		// 가운데 글자 구하기
		// getMiddle 메소드는 하나의 단어를 입력 받습니다.
		// 단어를 입력 받아서 가운데 글자를 반환하도록 getMiddle 메소드를 만들어 보세요.
		// 단어의 길이가 짝수일 경우 가운데 두글자를 반환하면 됩니다.
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		getMiddle(input);
		sc.close();
	}
	
	private static void getMiddle(String s) {
		int length = s.length();
		if (length % 2 == 1) {
			length /= 2;
			System.out.println(s.charAt(length));
			
		} else {
			length /= 2;
			System.out.println(s.substring(length-1, length+1));
		}
	}
}
