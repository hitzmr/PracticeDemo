package threadDemo;

public class ThreadDemo02 implements Runnable{

	public static void main(String[] args) {
		ThreadDemo02 threadDemo02 = new ThreadDemo02();
		Thread t1= new Thread(threadDemo02);
		Thread t2 = new Thread(threadDemo02);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName() + " i="+i);
		}
	}

}
