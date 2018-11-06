package threadTest;

public class NormalThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("MyThread 종료");
				} catch (Exception e) {
					
				}
			}
		};
		
		t.start();
		System.out.println("main() 종료");
	}

}
