package tv;

public class TV {
	// 필드 정의
	String modelName; // 모델명
	int nowChannel; // 현재 내가 보고있는 채널
	int nowVolume; // 현재 내가 실행하고 있는 볼륨의 크기
	boolean power; // 전원 상태
	
	// power 상태에 따라 전원을 켜거나 끄는 메소드
	public void pow() {
		power = !power;
	}
	
	void upCh() {
		nowChannel++;
	}
	
	void downCh() {
		nowChannel--;
	}
	
	void changeCh(int i) {
		nowChannel = i;
	}
	
	void upVolume() {
		nowVolume++;
	}
	
	void downVolume() {
		nowVolume--;
	}
}
