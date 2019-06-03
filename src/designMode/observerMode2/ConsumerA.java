package designMode.observerMode2;

public class ConsumerA extends Consumers{

	@Override
	public void watchPrice(float discount) {
		System.out.println("Consumer A noticed that the shop make a " + discount + " discount");
	}

}
