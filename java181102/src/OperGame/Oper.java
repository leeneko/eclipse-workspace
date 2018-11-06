package OperGame;

public abstract class Oper {
	int life;
	String[] msg;
	int max;
	int num1;
	int num2;
	
	public Oper(int life, String[] msg, int max) {
		this.life = life;
		this.msg = msg;
		this.max = max;
	}
	
	public int getLife() {
		return life;
	}
	String getMsg(int i) {
		return msg[i];
	}
	public abstract int getQuestion();
	
}
