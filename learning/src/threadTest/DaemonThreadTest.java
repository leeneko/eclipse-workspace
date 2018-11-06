package threadTest;

public class DaemonThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("MyThread 종료");
				} catch (Exception e) {
					
				}
			}
		};
		
		t.setDaemon(true);
		t.start();
		
		System.out.println("main() 종료");
	}

}
