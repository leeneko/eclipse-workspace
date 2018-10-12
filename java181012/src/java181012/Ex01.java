package java181012;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dnaInfo = { "T", "G", "C", "A", "G", "T", "C", "A", "G", "G", "T", "A", "C", "A", "T", "G", "T", "T", "G", "T", "G", "T", "C", "A" };
		
		Scanner sc = new Scanner(System.in);
		System.out.print("패턴 입력 >> ");
		String input = sc.next();
		
		String sum = "";
		int cnt = 0;
		
		for (int i = 0; i < dnaInfo.length - (input.length() - 1); i++) {
			for (int j = i; j < input.length() + i; j++) {
				sum += dnaInfo[j];
			}
			if (sum.equals(input)) {
				cnt++;
			}
			sum = "";
		}
		
		System.out.println("패턴이 같은 경우 : " + cnt);
		
		sc.close();
	}

}
