package Question5;

public class Question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		goBusan(new Train());
		goBusan(new Bus());
		goBusan(new Airplane());
	}
	
	private static void goBusan(Vehicle b) {
		b.go();
	}

}
