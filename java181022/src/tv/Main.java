package tv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫번째 TV 클래스에서 객체 생성
		// TV 객체에 있는 필드에 값을 넣어주세요
		// 모델명 - "삼성", 채널 - "10", 볼륨 - "10", 전원 - "false"

		Scanner sc = new Scanner(System.in);
		
		TV sTv = new TV();
		sTv.modelName = "삼성";
		sTv.nowChannel = 10;
		sTv.nowVolume = 10;
		sTv.power = false;
		
		int input = 0;
		
		System.out.print("TV의 전원을 켜려면 1을 입력해주세요 >> ");
		switch (sc.nextInt()) {
			case 1:
				sTv.pow();
				System.out.println("\n1.TV상태 확인 2.채널 올리기");
				System.out.println("3.채널 내리기 4.원하는 채널 변경");
				System.out.println("5.볼륨 올리기 6.볼륨 내리기");
				System.out.print("7.종료 >>");
				input = sc.nextInt();
				break;
		}
		
		while (sTv.power) {
			System.out.println("\n1.TV상태 확인 2.채널 올리기");
			System.out.println("3.채널 내리기 4.원하는 채널 변경");
			System.out.println("5.볼륨 올리기 6.볼륨 내리기");
			System.out.print("7.종료 >>");
			input = sc.nextInt();
			
			if (input == 1) {
				System.out.println("1. 모델명 : " + sTv.modelName);
				System.out.println("2. 채널 : " + sTv.nowChannel);
				System.out.println("3. 볼륨 : " + sTv.nowVolume + "\n");
			} else if (input == 2) {
				sTv.upCh();
				System.out.println("채널 : " + sTv.nowChannel);
			} else if (input == 3) {
				sTv.downCh();
				System.out.println("채널 : " + sTv.nowChannel);
			} else if (input == 4) {
				System.out.print("채널 입력 : ");;
				sTv.changeCh(sc.nextInt());
				System.out.println("채널 : " + sTv.nowChannel);
			} else if (input == 5) {
				sTv.upVolume();
				System.out.println("볼룸 : " + sTv.nowVolume);
			} else if (input == 6) {
				sTv.downVolume();
				System.out.println("볼룸 : " + sTv.nowVolume);
			} else if (input == 7) {
				System.out.println("종료되었습니다.");
				sTv.pow();
			} else {
				System.out.print("잘못입력해주셨습니다.");
			}
		}
	}

}
