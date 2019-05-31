package designMode.factoryMethod;

public class Bmw523Factory implements BmwFactory{

	@Override
	public Bmw523 create() {
		System.out.println(" create BMW523");
		return new Bmw523();
	}
	

}
