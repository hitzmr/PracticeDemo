package designMode.observerMode2;

public class Shop {

	public static void main(String[] args) {
		Subject subject = new Subject();
		Consumers consumerA = new ConsumerA();
		Consumers consumerB = new ConsumerB();
		Consumers consumerC = new ConsumerC();
		
		subject.add(consumerA);
		subject.add(consumerB);
		subject.add(consumerC);
		
		
		subject.makeDiscount(8.0f);;
	}

}
