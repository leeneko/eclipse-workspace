package threadTest;

public class ThreadJoinTest {

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
		t.start();
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main() 종료");
	}

}
