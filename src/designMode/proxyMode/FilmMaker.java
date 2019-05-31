package designMode.proxyMode;

public class FilmMaker {

	public static void main(String[] args) {
		ActorService actor = new ProxyActor();
		
		
		actor.show(2000f);
		actor.show(4000f);
	}

}
