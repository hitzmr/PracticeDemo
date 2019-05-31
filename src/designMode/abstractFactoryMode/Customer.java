package designMode.abstractFactoryMode;

public class Customer {

	public static void main(String[] args) {
		AbstractFactory factory = new Bmw430Factory();
		factory.createAirCondition();
		factory.createEngine();
		
		factory = new Bmw523Factory();
		factory.createAirCondition();
		factory.createEngine();
		
	}

}
