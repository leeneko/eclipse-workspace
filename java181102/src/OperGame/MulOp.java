package OperGame;

import java.util.Random;

public class MulOp extends Oper {

	public MulOp(int life, String[] msg, int max) {
		super(life, msg, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getQuestion() {
		num1 = new Random().nextInt(max) + 1;
		num2 = new Random().nextInt(max) + 1;
		return num1 * num2;
	}

}
