package sumTheMountOfWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SumCountDemo {

	public static void main(String[] args) throws InterruptedException {
		Member member = new Member();
		Thread t1 = new Thread(member);
		Thread t2 = new Thread(member);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		for(String value:member.map.keySet()){
			System.out.println("key:" + value + "\t value:" + member.map.get(value));
		}
//		System.out.println("key:Smith"+"\t value:" + member.map.get("Smith"));
		
	}
	

}

class Member implements Runnable{

	@Override
	public void run() {
		try {
			readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private long count=0;
	public ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();

	public synchronized void putValue(String value){
		if(map.containsKey(value)){
			count = map.get(value);
			map.put(value, ++count);
			System.out.println(Thread.currentThread().getName() + " is putting value:" + value + ", current count is:" + count);
		}else{
			map.put(value, (long) 1);
			System.out.println(Thread.currentThread().getName() + " is putting value:" + value + ", current count is:" + count);
		}
	}
	
	private boolean isNumber(String value){
		if(value.matches("[0-9]")) return true;
		return false;
	}
	
	public void readFile() throws Exception{
		File file = new File("C://Users//bsnpc1g//Desktop//TEST.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine()) != null){
//			 System.out.println(line);
			 List<String> lineList = splitLine(line);
			 for(String word : lineList){
//				 System.out.println(word);
				 if(!isNumber(word)) putValue(word);
			 }
		}
	}
	
	public List<String> splitLine(String strLine){
		return Arrays.asList(strLine.split("\t"));
	}
}