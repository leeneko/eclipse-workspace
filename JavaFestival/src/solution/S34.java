package solution;

public class S34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "01001101";
//		String str = "00101000";
		
		decimal(str);
	}

	private static void decimal(String str) {
		// TODO Auto-generated method stub
		String[] array = str.split(""); 
		int[] input = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			input[i] = Integer.parseInt(array[i]);
		}
//		Math.pow(a, b)
//		System.out.println((int) Math.pow(2, 3));
		int count = 0; // 10진수 누적
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 1) {
				count += (int) Math.pow(2, input.length -  1 - i);
			}
		}
		
		System.out.print(str + "(2) = " + count + "(10)");
	}

}
