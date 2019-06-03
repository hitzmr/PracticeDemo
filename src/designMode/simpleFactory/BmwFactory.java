package designMode.simpleFactory;

public class BmwFactory {
	public static Bmw getBmw(String no){
		if("430".equals(no)){
			return new Bmw430();
		}else if("523".equals("no")){
			return new Bmw523();
		}
		return null;
	}

}
