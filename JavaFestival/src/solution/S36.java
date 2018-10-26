package solution;

public class S36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//					03
//				12	13	14
//			21	22	23	24	25
//		30	31	32	33	34	35	36
//			41	42	43	44	45
//				52	53	54
//					63
		
		int[][] array = new int[7][7];
		int num = 1;

//		int i = 0	> 1 	> 2		> 3		> 4		> 5		> 6
//		int j = 3~3	> 2~4 	> 1~5	> 0~6	> 1~5	> 2~4	> 3~3
		int first = 3;
		int last = 3;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = first; j <= last; j++) {
				array[j][i] = num++;
			}
			if (i < 3) {
				first--;
				last++;
			} else if (6 > i|| i > 3) {
				first++;
				last--;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
