package designMode.observerMode2;

import java.util.ArrayList;
import java.util.List;


public class Subject implements Observerable{
	public static List<Consumers> observers = new ArrayList<Consumers>();
	public float discount;
	
	public void makeDiscount(float discount){
		this.discount = discount;
		System.out.println("The master of the shop decide to make a " + discount + " discount");
		notifyAllConsumers();
		
	}
	
	@Override
	public void add(Consumers consumer){
		observers.add(consumer);
	}
	
	@Override
	public void del(Consumers consumer){
		observers.remove(consumer);
	}
	
	
	@Override
	public void notifyAllConsumers(){
		for(Consumers consumer : observers){
			consumer.watchPrice(discount);
		}
	}
}
