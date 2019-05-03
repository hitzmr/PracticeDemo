package inverseSearch;

public class InversSearchDemo {
	public static void main(String[] args) {
		InversSearchDemo insd = new InversSearchDemo();
		String testStr = "BAasdfgnmmjhgfdsaxfcgjnhmkA";
		
		System.out.println(insd.getNextA(testStr));
	}
	
	public int getNextA(String str){
		if(null == str) return 0 ;
		if(str.contains("A")){
			int pos = str.indexOf("A");
			String subStr = str.substring(pos + 1);
			return 1 + getNextA(subStr);
		}
		return 0;
	}

}
