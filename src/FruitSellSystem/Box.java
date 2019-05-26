package FruitSellSystem;

public class Box {
	private Dealers dealer;
	private Intermediaries intermediaries;
	private Farmers farmer;
	private Fruit fruit;
	private float weight;
	private float capacity;
	
	
	public Dealers getDealer() {
		return dealer;
	}


	public void setDealer(Dealers dealer) {
		this.dealer = dealer;
	}


	public Intermediaries getIntermediaries() {
		return intermediaries;
	}


	public void setIntermediaries(Intermediaries intermediaries) {
		this.intermediaries = intermediaries;
	}


	public Farmers getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmers farmer) {
		this.farmer = farmer;
	}


	public Fruit getFruit() {
		return fruit;
	}


	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public float getCapacity() {
		return capacity;
	}


	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}


	public Box(Dealers dealer, Intermediaries intermediaries, Farmers farmer,
			Fruit fruit, float weight, float capacity) {
		super();
		this.dealer = dealer;
		this.intermediaries = intermediaries;
		this.farmer = farmer;
		this.fruit = fruit;
		this.weight = weight;
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Box [dealer=" + dealer + ", intermediaries=" + intermediaries
				+ ", farmer=" + farmer + ", fruit=" + fruit + ", weight="
				+ weight + ", capacity=" + capacity + "]";
	}
	
	

}
