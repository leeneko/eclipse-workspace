package java181005;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("abc"); // String a = "abc";
		String b = new String("abc");
		
		System.out.println(a == b); // returns false, �ּ� ��
		System.out.println(a.equals(b)); // returns true, ����� �� ��
	}

}
