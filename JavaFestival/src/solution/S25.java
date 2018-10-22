package solution;

public class S25 {

	public static void main(String[] args) {
		// 1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 점(index)들을 출력
		int[] point = { 92, 32, 52, 9, 81, 2, 68 };
		int[] result = { 0, 100 }; // 거리가 짧은 점 index 저장 및 출력
		
		// 01, 02, 03, 04, 05, 06 비교
		// 12, 13, 14, 15, 16 비교
		// 23, 24, 25, 26 비교
		// 34, 35, 26
		// 45, 46
		// 56
		for (int i = 0; i < point.length; i++) {
			for (int j = i+1; j <= point.length; j++) {
				if (j == 7) { // ArrayIndexOutOfBoundsException 회피
					break;
				}
				if (point[i] > point[j]) {
					if (point[i] - point[j] < result[1] - result[0]) {
						result[1] = point[i];
						result[0] = point[j];
					}
				} else {
					if (point[j] - point[i] < result[1] - result[0]) {
						result[1] = point[j];
						result[0] = point[i];
					}
				}
			}
		}

		// 가장 작은 수가 저장되어있는 result로부터 index를 추출
		for (int i = 0; i < point.length; i++) {
			if (result[0] == point[i]) {
				result[0] = i;
			}
			if (result[1] == point[i]) {
				result[1] = i;
			}
		}
		
		// 앞 index 값이 뒤 index 값보다 클 경우 앞, 뒤 변경
		int temp = 0;
		if (result[0] > result[1]) {
			temp = result[0];
			result[0] = result[1];
			result[1] = temp;
		}
		
		// 출력
		System.out.println("result = [" + result[0] + ", " + result[1] + "]");
	}

}
