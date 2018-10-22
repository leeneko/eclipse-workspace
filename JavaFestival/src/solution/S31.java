package solution;

public class S31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ASKII code
//		A 65 ~ Z 90
//		91 > 65 // 26
//		a 97 ~ z 122
//		123 > 97 // 26
		
		System.out.println(caesar("a B z", 4));
	}
	
	private static String caesar(String s, int e) {
		String output = "";
		char[] array = s.toCharArray();
		int temp;
		int over = 26;
		
		for (int i = 0; i < array.length; i++) {
			if ((int) array[i] == 32) { // 32(blank)일 때 그대로 누적
				output += array[i];
			} else if (array[i] >= 65 && array[i] <= 90) {
				if ((int) array[i] + e > 90) { // 90 초과시 A(65)로 줄이기
					temp = ((int) array[i] - over) + e;
					array[i] = (char) temp;
					output += array[i];
				} else {
					temp = (int) array[i] + e;
					array[i] = (char) temp;
					output += array[i];
				}
			} else {
				if ((int) array[i] + e > 122) {
					temp = ((int) array[i] - over) + e;
					array[i] = (char) temp;
					output += array[i];
				} else {
					temp = (int) array[i] + e;
					array[i] = (char) temp;
					output += array[i];
				}
			}
		}
		
		return output;
	}

}
