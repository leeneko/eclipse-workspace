package student;

public class Student {
	private String name; // 이름
	private int stNum; // 학번
	private int javaScore;
	private int webScore;
	private int androidScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int i) {
		this.stNum = i;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int i) {
		this.javaScore = i;
	}
	public int getWebScore() {
		return webScore;
	}
	public void setWebScore(int i) {
		this.webScore = i;
	}
	public int getAndroidScore() {
		return androidScore;
	}
	public void setAndroidScore(int i) {
		this.androidScore = i;
	}
}