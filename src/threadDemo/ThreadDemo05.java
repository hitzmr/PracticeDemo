package threadDemo;

public class ThreadDemo05 implements Runnable{
	public static void main(String[] args){
		ThreadDemo05 td = new ThreadDemo05();
		Thread t1 = new Thread(td);
		Thread t2 = new Thread(td);
		
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		synchronized(this){
			for(int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName() + " print: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
