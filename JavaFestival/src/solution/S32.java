package solution;

public class S32 {

	public static void main(String[] args) {
		System.out.println(change124(18));
	}

	private static String change124(int i) {
		//	10진법	3진법		124진법
		//	1		1		1
		//	2		2		2
		//	3		10		4
		//	4		11		11
		//	5 		12		12
		//	6		20		14
		//	7		21		21
		//	8		22		22
		//	9		100		24
		//	10		101		41
		//	11		102		42
		//	12		110		44
		//	13		111		111
		//	14		112		112
		//	15		120		114
		//	16		121		121
		//	17		122		122
		//	18		200		124
		//	19		201		141
		//	20		202		142
		//	21		210		144
		//	22		211		211
		//	23		212		212
		//	24		220		214
		//	25		221		221 
		//	26		222		222
		//	27		300		224
		//	28		301		241
		//	29		302		242
		//	30		1010	244
		//	31		1011	411
		//	32		1012	412
		//	33		1020	421
		//	34		1021	422
		//	35		1022	424
		//	36		1100	441
		//	37		1101	442
		//	38		1102	444
		//	39		1110	1111
		//	40		1111	1112
		//	41		1112	1114
		//	42		1120	1121
		
		String output = "";
		
		int num; // 나머지 - 몫 : i
		
		while (i > 0) {
			num = i % 3;
			
			i = i / 3;
			if (num == 0) {
				num = 4;
				i--;
			}
			
//			System.out.println("몫(i) : " + i);
//			System.out.println("나머지(num) : " + num);
			
			output += num;
		}
		output = (new StringBuffer(output)).reverse().toString();
		
		return output;
	}

}
