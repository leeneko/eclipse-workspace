package java181018;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("박병관", 29); // "박병관" : 'Parameter'
		print("김동원", 43);
	}
	
	public static void print(String name, int age) { // String name : 'Argument'
		System.out.println(name + age + " 안녕하세요.");
	}

}
