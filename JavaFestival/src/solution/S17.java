package solution;

import java.util.Scanner;

public class S17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("n 입력 : ");
		int input = sc.nextInt();
		
		int result = 1;
		for (int i = 0; i < input; i++) {
			result += i;
			System.out.print(result + " ");
		}
	}

}
