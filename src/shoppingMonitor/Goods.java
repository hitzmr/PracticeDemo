package shoppingMonitor;

public class Goods {
	// ��Ʒ����
	private String name;
	
	// ��Ʒ���
	private String number;
	
	//��Ʒ�۸�
	private float price;
	
	// ��������
	private String shopName;
	
	// ��Ʒ�ײ���Ϣ
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
