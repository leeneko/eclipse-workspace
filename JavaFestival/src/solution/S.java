package solution;

public class S {

	public static void main(String[] args) {
		int i = 8;
		String output = "";
		
		int num; // 나머지 - 몫 : ix
		
		while (i > 0) {
			num = i % 3;
			i = i / 3;
//			if (num == 0) {
//				num = 4;
//				i--;
//			}
			
			output += num;
		}
		output = new StringBuffer(output).reverse().toString();
		
		System.out.println(output);
		
		int n = 8;
		
		String temp = Integer.toBinaryString(n);
		System.out.println(temp);
	}

}
