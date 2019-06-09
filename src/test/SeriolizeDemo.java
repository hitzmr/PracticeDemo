package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SeriolizeDemo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public SeriolizeDemo(String name, int age, float score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}


	@Override
	public String toString() {
		return "test.SeriolizeDemo [name=" + name + ", age=" + age + ", score="
				+ score + "]";
	}


	private int age;
	private float score;
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SeriolizeDemo ser = new SeriolizeDemo("bsnpc1g", 28, 100f);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\bsnpc1g\\Desktop\\ser.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ser);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\bsnpc1g\\Desktop\\ser.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SeriolizeDemo s = (SeriolizeDemo)ois.readObject();
		System.out.println(s);
		
	}

}
