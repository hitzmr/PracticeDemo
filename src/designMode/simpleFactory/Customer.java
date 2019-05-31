package designMode.simpleFactory;

public class Customer {

	public static void main(String[] args) {
		Bmw430 bmw430 = (Bmw430) BmwFactory.getBmw("430");
		Bmw523 bmw523 = (Bmw523) BmwFactory.getBmw("523");
	}

}
