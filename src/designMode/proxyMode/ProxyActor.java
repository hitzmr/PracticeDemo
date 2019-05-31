package designMode.proxyMode;

public class ProxyActor implements ActorService{

	@Override
	public void show(float money) {
		
		if(money < 3000f){
			System.out.println("Proxy say the actor will not show unless the money is larger that 3000");
			return;
		}
		
		RealActor actor = new RealActor();
		actor.show(money-1000);
	}
	
}
