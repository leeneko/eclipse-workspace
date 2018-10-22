package java181019;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "apple";
		
		// startsWith( 안에 쓰여진 ) 값으로 시작하는지
		System.out.println(str.startsWith("a"));
		// endsWith( 안에 쓰여진 ) 값으로 끝나는지
		System.out.println(str.endsWith("e"));
		
		// indexOf( 안에 쓰여진 ) 값의 순서 반환
		System.out.println(str.indexOf("l")); // returns 3
		System.out.println(str.indexOf("p")); // returns 1
		// 뒤에서부터 안의 값을 찾는다
		System.out.println(str.lastIndexOf("p")); // returns 2
		
		// 길이를 알려주는 메소드
		System.out.println(str.length()); // returns 5
		
		String phone = "010-4611-5278";
		// replace( ⓐ, ⓑ ) - a의 값을 b로 변환하는 메소드
		System.out.println(phone.replace("-", "*"));
		
		String score = "A,B,C,D,E,F";
		// split ( 안의 문자를 기준으로 ) 분할하여 배열에 저장
		String[] sArray = score.split(",");
		for (int i = 0; i < sArray.length; i++) {
			System.out.print(sArray[i]);
		}
		System.out.println();
		
		String name = "김선민김경민정승우이병진박종진";
		// substring( a, b ) a부터 b 앞의 글자까지
		String cName = name.substring(0, 3);
		System.out.println(cName);
		System.out.println(name.substring(3, 6));
		
		String s = "abcdEFG";
		// 소문자로 변환하는 메소드
		System.out.println(s.toLowerCase());
		// 대문자로 변환하는 메소드
		System.out.println(s.toUpperCase());
		
		String b = "         Hello World!     ";
		// 문자열 앞, 뒤의 공백을 없애주는 메소드
		System.out.println(b.trim());
		
		// 숫자를 문자열(String)으로 바꾸는 메소드
		// String c = 10 + "";
		String c = String.valueOf(10);
		System.out.println(c);
		
		String str3 = "박병관";
		String str4 = "병";
		// a.contains( b ) a 안에 b가 속해있는지 안속해있는지 bool 반환
		System.out.println(str3.contains(str4)); // returns true
		
		String str5 = "abcdefg";
		char ca = str5.charAt(3); // a 안의 b 인덱스 값을 반환
		System.out.println(ca); // returns d
		
		String str6 = "Amen";
		// replace(a, b) 첫번째로 찾은 a 값을 b로 변환
		System.out.println(str6.replaceFirst("A", "Super"));
		
		int[] array = { 6, 1, 7, 2, 9, 5, 3 };
		// 오름차순 정렬 메소드 Arrays.sort( a );
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

}
