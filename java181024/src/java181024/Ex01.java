package java181024;

import java.util.ArrayList;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		arrayList.add("사과");
		arrayList.add("배");
		arrayList.add("망고");
		arrayList.add("귤");
		arrayList.add("딸기");
		
		arrayList.add(2, "바나나");
		
		arrayList.remove(4);
		
//		arrayList.removeAll(arrayList);
		
//		String a = arrayList.get(0);
//		int a = arrayList(0);
		
		for (String string : arrayList) {
			System.out.println(string);
		}
		
//		arrayList.add("사과");
//		System.out.println(arrayList.get(0));
	}

}
