package animal;

import java.util.ArrayList;

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
		
		Cat hodoo = new Cat();
		hodoo.name = "호두";
		hodoo.life = 419;
		
		Animal[] array = new Animal[3];
		array[0] = simba;
		array[1] = hodoo;
		array[2] = cat;
		
		System.out.println("array 활용");
		for (int i = 0; i < array.length; i++) {
			array[i].eating();
		}
		
		ArrayList<Animal> list = new ArrayList<Animal>();
		list.add(simba);
		list.add(cat);
		list.add(hodoo);
		
		System.out.println("\nArrayList 활용");
		for (int i = 0; i < list.size(); i++) {
			list.get(i).eating();
		}
		
		// 업 캐스팅
//		Animal l = simba;
//		Animal d = cat;
//		Animal f = new Cat();
//		
//		l.eating();
//		d.eating();
//		f.eating();
		
		// 다운 캐스팅 : ((Lion) l).hunting();
	}

}
