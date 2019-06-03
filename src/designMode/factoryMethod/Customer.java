package designMode.factoryMethod;

public class Customer {
	public static void main(String[] args){
		BmwFactory bmwFactory = new Bmw430Factory();
		bmwFactory.create();
		
		bmwFactory = new Bmw523Factory();
		bmwFactory.create();
	}

}
