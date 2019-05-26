package FruitSellSystem;

import java.util.Date;

public class SalesOrders {
	private String saleOrderNo;
	private Date saleDate;
	private Farmers farmer;
	private Dealers delear;
	private Intermediaries intermediaries;
	private Fruit fruit;
	private int account;
	private Box box;
	private float price;
	public String getSaleOrderNo() {
		return saleOrderNo;
	}
	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Farmers getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmers farmer) {
		this.farmer = farmer;
	}
	public Dealers getDelear() {
		return delear;
	}
	public void setDelear(Dealers delear) {
		this.delear = delear;
	}
	public Intermediaries getIntermediaries() {
		return intermediaries;
	}
	public void setIntermediaries(Intermediaries intermediaries) {
		this.intermediaries = intermediaries;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public SalesOrders(String saleOrderNo, Date saleDate, Farmers farmer,
			Dealers delear, Intermediaries intermediaries, Fruit fruit,
			int account, Box box, float price) {
		super();
		this.saleOrderNo = saleOrderNo;
		this.saleDate = saleDate;
		this.farmer = farmer;
		this.delear = delear;
		this.intermediaries = intermediaries;
		this.fruit = fruit;
		this.account = account;
		this.box = box;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SalesOrders [saleOrderNo=" + saleOrderNo + ", saleDate="
				+ saleDate + ", farmer=" + farmer + ", delear=" + delear
				+ ", intermediaries=" + intermediaries + ", fruit=" + fruit
				+ ", account=" + account + ", box=" + box + ", price=" + price
				+ "]";
	}
	
	
	

}
