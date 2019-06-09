package threadDemo;

public class ThreadDemo04 extends Thread{
	public Object lock;
	
	public ThreadDemo04(Object lock){
		this.lock = lock;
	}

	public static void main(String[] args){
		Object lock = new Object();
		ThreadDemo04 t1 = new ThreadDemo04(lock);
		ThreadDemo04 t2 = new ThreadDemo04(lock);
		t1.start();
		t2.start();
		
	}

	@Override
	public void run() {
		synchronized(lock){
			for(int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName() + " print: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
