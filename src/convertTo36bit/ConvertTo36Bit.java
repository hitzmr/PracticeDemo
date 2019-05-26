package convertTo36bit;

public class ConvertTo36Bit {

	public static void main(String[] args) {
		System.out.println(ConvertTo36Bit.convertTo36(51));
		
	}
	
	public static String convertTo36(long seq){
		String res = "";
		int q = 0;
		int r = 0;
		while(seq != 0){
			r = (int) seq%36;
			q = (int) seq/36;
			res = ConvertTo36Bit.getSeqWord(r) + res;
			seq = q;
		}
		return res;
	}
	
	public static int getSeqNo(char word){
		if (word >= 0 && word <=9){
			return (int)word;
		}else{
			return (int)word -54;
		}
	}
	
	public static long convertTo10(String str36){
		long seqNo = 0;
		for (int i=0; i<str36.length(); i++){
			seqNo += ConvertTo36Bit.getSeqNo(str36.charAt(i))*(36^(str36.length() - i - 1));
		}
		
		return seqNo;
	}
	
	public static String getSeqWord(int seqNo){
		if (seqNo >= 1 && seqNo <= 9){
			return String.valueOf(seqNo);
		}else{
			return String.valueOf((char)(seqNo + 55));
		}
	}
	
}
