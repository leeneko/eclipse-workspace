package threadTest;

class AdvancedStopThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Thread alive");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			
		} finally {
			System.out.println("Thread dead");
		}
	}
	
}

public class AdvancedStopThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("# Start AdvancedStopThreadTest.java");
		AdvancedStopThreadTest astt = new AdvancedStopThreadTest();
		astt.process();
	}

	private void process() {
		// TODO Auto-generated method stub
		AdvancedStopThread ast = new AdvancedStopThread();
		Thread thread = new Thread(ast);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
