package FruitSellSystem;

public class Farmers {
	private String name;
	private String phoneNum;
	private String address;
	
	
	public Farmers(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}


	public Farmers(String name) {
		super();
		this.name = name;
	}


	public Farmers(String name, String phoneNum, String address) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Farmers [name=" + name + ", phoneNum=" + phoneNum
				+ ", address=" + address + "]";
	}
	
	

}
