package solution;

public class S15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 8;
		
		for (int i = 1; i <= input; i++) {
			System.out.print(fibo(i)+" ");
		}
	}
	
	public static int fibo(int n) {
		if (n <= 1)
			return n;
		else
			return fibo(n-2) + fibo(n-1);
	}

}
