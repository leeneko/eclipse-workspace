package OperGame;

import java.util.Random;

public class MinusOp extends Oper {

	public MinusOp(int life, String[] msg, int max) {
		super(life, msg, max);
	}

	@Override
	public int getQuestion() {
		num1 = new Random().nextInt(max) + 1;
		num2 = new Random().nextInt(max) + 1;
		return num1 - num2;
	}

}
