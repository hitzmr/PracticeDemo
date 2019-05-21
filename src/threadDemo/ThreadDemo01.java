package threadDemo;

public class ThreadDemo01 extends Thread{
	

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName() + " i="+i);
		}
	}

	public static void main(String[] args) {
		ThreadDemo01 threadDemo01 = new ThreadDemo01();
		Thread t1 = new Thread(threadDemo01);
		Thread t2 = new Thread(threadDemo01);
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("main thread end");
		
	}

}
