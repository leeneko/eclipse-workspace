package solution;

public class Expressions {

	public int expressions(int e) {
		// TODO Auto-generated method stub
		int result = 0;
		
		int temp = 0;
		for (int i = 0; i <= e; i++) {
			while (i <= e) {
				temp += i;
				System.out.println("temp + i = " + temp);
				if (temp == e) {
					result++;
					System.out.println("result = " + result);
					temp = 0;
				}
				if (temp > e) {
					temp = 0;
				}
				i++;
			}
		}
		
		return result;
	}

}
