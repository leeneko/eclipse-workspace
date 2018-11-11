package Qustion4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Mouse> list = new ArrayList<Mouse>();
		
		list.add(new Mouse());
		list.add(new WheelMouse());
		list.add(new LightMouse());
		
		((WheelMouse) list.get(1)).wheelUp();
		((LightMouse) list.get(2)).shineLight();
	}

}
