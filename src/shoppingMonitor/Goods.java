package shoppingMonitor;

public class Goods {
	// 商品名称
	private String name;
	
	// 商品编号
	private String number;
	
	//商品价格
	private float price;
	
	// 店铺名称
	private String shopName;
	
	// 商品套餐信息
	private String comments;

	public Goods(String name, String number, float price, String shopName,
			String comments) {
		super();
		this.name = name;
		this.number = number;
		this.price = price;
		this.shopName = shopName;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", number=" + number + ", price="
				+ price + ", shopName=" + shopName + ", comments=" + comments
				+ "]";
	}
	
	

}
