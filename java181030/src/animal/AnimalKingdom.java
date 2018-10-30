package animal;

public class AnimalKingdom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion simba = new Lion();
		simba.name = "심바";
		simba.life = 50;
//		simba.hunting(simba.name);
//		simba.eating();
		
		Dog cat = new Dog();
		cat.name = "나비";
		cat.life = 15;
//		cat.cuting(cat.name);
//		cat.eating();
		
		// 업 캐스팅
		Animal l = simba;
		Animal d = cat;
		Animal f = new Cat();
		
		Animal a = new Animal();
		
		l.eating();
		d.eating();
		f.eating();
		
		// 다운 캐스팅 : ((Lion) l).hunting();
	}

}
