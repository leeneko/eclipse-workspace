package OperGame;

import java.util.Random;

public class UpOp extends Oper {

	public UpOp(int life, String[] msg, int max) {
		super(life, msg, max);
	}

	@Override
	public int getQuestion() {
		num1 = new Random().nextInt(max) + 1;
		num2 = new Random().nextInt(max) + 1;
		return num1 + num2;
	}
	
}
