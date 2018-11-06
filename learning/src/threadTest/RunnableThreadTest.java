package threadTest;

class RunnableThread implements Runnable {
	public void run() {
		System.out.println("Runnable 인터페이스 구현");
	}
}

public class RunnableThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new RunnableThread());
		t.start();
	}

}
