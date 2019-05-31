package designMode.observerMode2;

public interface Observerable {
	public void add(Consumers consumer);
	public void del(Consumers consumer);
	public void notifyAllConsumers();
}
