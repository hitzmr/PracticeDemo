package designMode.proxyMode;

public class RealActor implements ActorService{

	@Override
	public void show(float money) {
		System.out.println("Real Actor Start to Show, and he will get " + money);
	}
	
}
