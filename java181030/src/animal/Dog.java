package animal;

public class Dog extends Animal {
	@Override
	public void eating() {
		System.out.println("사료를 먹습니다");
	}
	public void eating(String s) {
		System.out.println(s + "은(는) 사료를 먹습니다");
	}
	public void cuting() {
		System.out.println("미용실에서 털을 자르다");
	}
	public void cuting(String s) {
		System.out.println(s + "은(는) 미용실에서 털을 자르다");
	}
}
