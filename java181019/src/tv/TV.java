package tv;

public class TV {
	String modelName;
	boolean power;
	int price;
	double inch;
	int channel;
	int nowChannel; // 현재 채널 번호
	int vol;
	
	public void power() {
		power = !power;
	}

	public void upChannel() {
		// TODO Auto-generated method stub
		nowChannel++;
	}

	public void downChannel() {
		// TODO Auto-generated method stub
		nowChannel--;
	}
}
