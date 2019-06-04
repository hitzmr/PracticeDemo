package designMode.prototype;

import java.util.HashMap;
import java.util.Map;

public class AnimalCache {
	private static Map<String, Animal> cache = new HashMap<String, Animal>();
	
	public static void loadCache(){
		cache.put("Cat", new Cat());
		cache.put("Dog", new Dog());
		cache.put("Bird", new Bird());
	}
	
	public Object getAnimal(String name) throws CloneNotSupportedException{
		return cache.get(name).clone();
	}

}
