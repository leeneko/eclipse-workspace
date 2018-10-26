package solution;

import java.util.Random;

public class S16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int[] array = new int[6];
		
		while (true) {
			for(int i = 0; i < array.length; i++)
				array[i] = rnd.nextInt(45)+1;
			if (array[0] != array[1] || array[0] != array[2] || array[0] != array[3] || array[0] != array[4] || array[0] != array[5] ||
					array[1] != array[2] || array[1] != array[3] || array[1] != array[4] || array[1] != array[5] ||
					array[2] != array[3] || array[2] != array[4] || array[2] != array[5] ||
					array[3] != array[4] || array[3] != array[5] || array[4] != array[5]) {
				break;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("행운의 숫자 : " + array[i]);
		}
	}

}
