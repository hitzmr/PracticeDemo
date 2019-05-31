package designMode.observerMode2;

public class ConsumerB extends Consumers{

	@Override
	public void watchPrice(float discount) {
		System.out.println("Consumer B noticed that the shop make a " + discount + " discount");
	}

}
