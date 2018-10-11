package 이병진_개인실기;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myScore = new int[3];
		myScore[0] = 75; // 자바 점수
		myScore[1] = 85; // web 점수
		myScore[2] = 35; // Android 점수
		int min = 0;
		
		for (int i = 100; i > min; i -= 10) {
			System.out.print(i + "\t");
			for (int j = 0; j < myScore.length; j++) {
				if (myScore[j] > i) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		System.out.print("\tJava점수\tWeb점수\tAndroid점수");
	}

}
