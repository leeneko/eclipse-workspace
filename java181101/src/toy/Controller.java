package toy;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
	
	ArrayList<Toy> list = new ArrayList<Toy>();
	Random rd;
	
	Controller() {
		list.add(new Ball());
		list.add(new Train());
		list.add(new Gun());
	}
	
	Toy getToy() {
		rd = new Random();
		
		return list.get(rd.nextInt(list.size()));
	}
	
}
