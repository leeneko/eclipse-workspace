package tv;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV myTV = new TV();
		
		myTV.modelName = "삼성";
		myTV.price = 10000000;
		myTV.inch = 24;
		myTV.channel = 120;
		myTV.vol = 100;
		myTV.power = false;
		myTV.nowChannel = 12;
		
		System.out.println(myTV.modelName);
		System.out.println(myTV.price);
		System.out.println(myTV.inch);
		System.out.println(myTV.channel);
		System.out.println(myTV.vol);
		System.out.println(myTV.power);
		
		myTV.power();
		System.out.println(myTV.power);
		
		TV yourTV = new TV();
		
		yourTV.modelName = "LG";
		yourTV.price = 20000000;
		yourTV.inch = 30;
		yourTV.channel = 240;
		yourTV.vol = 100;
		yourTV.power = false;
		
		System.out.println(yourTV.modelName);
		System.out.println(yourTV.price);
		System.out.println(yourTV.inch);
		System.out.println(yourTV.channel);
		System.out.println(yourTV.vol);
		System.out.println(yourTV.power);
		
		yourTV.power();
		System.out.println(yourTV.power);
		
		myTV.upChannel();
		System.out.println(myTV.nowChannel);
		
		myTV.downChannel();
		System.out.println(myTV.nowChannel);
	}

}
