package pokemon;

import java.util.ArrayList;

public class pokemonCont {
	ArrayList<pokemonVO> list = new ArrayList<pokemonVO>();
	
	public int size() {
		return list.size();
	}
	
	public pokemonVO get(int i) {
		return list.get(i);
	}
}
