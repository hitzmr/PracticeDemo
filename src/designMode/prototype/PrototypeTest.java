package designMode.prototype;

public class PrototypeTest {
	public static void main(String[] args) throws CloneNotSupportedException{
		AnimalCache.loadCache();
		AnimalCache cache = new AnimalCache();
		Cat cat = (Cat) cache.getAnimal("Cat");
		Dog dog = (Dog) cache.getAnimal("Dog");
		Bird bird = (Bird) cache.getAnimal("Bird");
		
		cat.tell();
		dog.tell();
		bird.tell();
	}
}
