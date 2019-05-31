package designMode.factoryMethod;

public class Bmw430Factory implements BmwFactory{

	@Override
	public Bmw430 create() {
		System.out.println(" create BMW430");
		return new Bmw430();
	}
	

}
