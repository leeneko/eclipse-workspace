import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int num1 = 0;
		int num2 = 0;
		
		for (int i = 1; i <= input; i++) {
			if (i % 2 == 0) {
				num1 += i;
			} else {
				num2 += i;
			}
		}
		
		System.out.println("짝수의 합 : " + num1);
		System.out.println("홀수의 합 : " + num2);
	}

}
