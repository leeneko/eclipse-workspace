package solution;

public class S33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] array = new char[5][5];
		
//		00	01	02	03	04
//		10	11	12	13	14
//		20	21	22	23	24
//		30	31	32	33	34
//		40	41	42	44	45
		
//		A	B	C	D	E
//			F	G	H
//				I
//			J	K	L
//		M	N	O	P	Q
		
//		A : 65 ~ Q : 81
		
//		i 0		1	2	3	4
//		j 0~4	1~3	2~2	1~3	0~4
		
		int al = 65;
		int first = 0;
		int last = 4;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = first; j <= last; j++) {
				array[i][j] = (char) al++;
			}
			if (i < 2) {
				first++;
				last--;
			} else {
				first--;
				last++;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
