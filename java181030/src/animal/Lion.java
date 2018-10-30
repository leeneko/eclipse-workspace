package animal;

public class Lion extends Animal {
	/*String name;
	int life;
	
	public void eating() {
		System.out.println("먹습니다");
	}*/
	public void eating() {
		System.out.println("고기를 먹습니다");
	}
	public void eating(String s) {
		System.out.println(s + "은(는) 고기을(를) 먹습니다");
	}
	public void hunting() {
		System.out.println("사냥을 합니다");
	}
	public void hunting(String s) {
		System.out.println(s + "은(는) 사냥을 합니다");
	}
}
