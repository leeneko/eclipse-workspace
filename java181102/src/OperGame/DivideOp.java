package OperGame;

import java.util.Random;

public class DivideOp extends Oper {

	public DivideOp(int life, String[] msg, int max) {
		super(life, msg, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getQuestion() {
		// TODO Auto-generated method stub
		num1 = new Random().nextInt(max) + 1;
		num2 = new Random().nextInt(max) + 1;
		return num1 / num2;
	}

}
