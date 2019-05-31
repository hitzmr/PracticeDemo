package designMode.observerMode2;

public class ConsumerC extends Consumers{

	@Override
	public void watchPrice(float discount) {
		System.out.println("Consumer C noticed that the shop make a " + discount + " discount");
	}

}
