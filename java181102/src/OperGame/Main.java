package OperGame;

public class Main {

	public static void main(String[] args) {
		// 랜덤 숫자 두개를 뽑는다
		// 문제를 출력해준다
		// 출력 예) 2 + 3 =
		// 답을 입력받고 답이 맞으면 참잘했어요!
		// 틀렸으면 멍청이!, 어휴, 바보...
		// 총 life는 3개
		Controller c = new Controller();
		String[] msg  = {"멍청이!", "에휴", "바보..."};
		UpOp o1 = new UpOp(3, msg, 9);
		c.play(o1);
	}
	
	

}
