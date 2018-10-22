package solution;

public class S28 {

	public static void main(String[] args) {
		// 2차원 배열 90도 회전하여 출력
		// 원본
		//	1	2	3	4	5
		//	6	7	8	9	10
		//	11	12	13	14	15
		//	16	17	18	19	20
		//	21	22	23	24	25
		
		// 90도 회전
		//	5	10	15	20	25
		//	4	9	14	19	24
		//	3	8	13	18	23
		//	2	7	12	17	22
		//	1	6	11	16	21
		
		int[][] array = new int[5][5];
		int cnt = 0;
		
		System.out.println("원본");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				cnt++;
				array[i][j] = cnt;
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
		//	04	14	24	34	44
		//	03	13	23	33	43
		//	02	12	22	32	42
		//	01	11	21	31	41
		//	00	10	20	30	40
		System.out.println("90도 회전");
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j][i] + "\t");
			}
			System.out.println();
		}

	}

}
