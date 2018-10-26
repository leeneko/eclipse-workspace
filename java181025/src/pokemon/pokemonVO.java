package pokemon;

public class pokemonVO {
	private int num;
	private String name;
	private String type;
	private int height;
	private int weight;
	private String gender;
	
	public pokemonVO() {
		
	}
	public pokemonVO(int num, String name, String type, int height, int weight, String gender) {
		this.num = num;
		this.name = name;
		this.type = type;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
