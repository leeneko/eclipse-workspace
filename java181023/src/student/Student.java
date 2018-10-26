package student;

public class Student { // VO (Value Object) : 생성자, 필드, getter, setter (= DataTransferObject)
	private String name; // 이름
	private int stNum; // 학번
	private int javaScore;
	private int webScore;
	private int androidScore;
	
	public Student() {
		
	}
	
	public Student(String name, int stNum, int javaScore, int webScore, int androidScore) {
		this.name = name;
		this.stNum = stNum;
		this.javaScore = javaScore;
		this.webScore = webScore;
		this.androidScore = androidScore;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String s) {
		this.name = s;
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