package java181023;

import java.util.ArrayList;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("c");
		list.add("d");
		list.add(1, "b");
		
		list.remove(1);
//		list.removeAll(list); // 전체 삭제
		
		System.out.println(list.size());
		
		for (String string : list) {
			System.out.print(string);
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

}
