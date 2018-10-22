package solution;

public class S33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q" };
		
		//0	// 0	1	2	3	4
		//1	// b	5	6	7	b
		//2	// b	b	8	b	b
		//3	// b	9	10	11	b
		//4	// 12	13	14	15	16
		
		for (int i = 0; i < 5; i++) {
			System.out.print(alpha[i] + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < 1; i++) {
			System.out.print("\t");
		}
		for (int i = 5; i < 8; i++) {
			System.out.print(alpha[i] + "\t");
		}
		for (int i = 0; i < 1; i++) {
			System.out.print("\t");
		}
		System.out.println();
		
		for (int i = 0; i < 2; i++) {
			System.out.print("\t");
		}
		for (int i = 8; i < 9; i++) {
			System.out.print(alpha[i] + "\t");
		}
		for (int i = 0; i < 2; i++) {
			System.out.print("\t");
		}
		System.out.println();
		
		for (int i = 0; i < 1; i++) {
			System.out.print("\t");
		}
		for (int i = 9; i < 12; i++) {
			System.out.print(alpha[i] + "\t");
		}
		for (int i = 0; i < 1; i++) {
			System.out.print("\t");
		}
		System.out.println();
		
		for (int i = 12; i < alpha.length; i++) {
			System.out.print(alpha[i] + "\t");
		}
		System.out.println();
	}

}
