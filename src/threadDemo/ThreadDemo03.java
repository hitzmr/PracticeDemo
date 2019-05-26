package threadDemo;

public class ThreadDemo03 implements Runnable{
	private String name;

	
	public ThreadDemo03(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		ThreadDemo03 threadDemo03a = new ThreadDemo03("a");
		ThreadDemo03 threadDemo03b = new ThreadDemo03("b");
		ThreadDemo03 threadDemo03c = new ThreadDemo03("c");
		Thread t1 = new Thread(threadDemo03a);
		Thread t2 = new Thread(threadDemo03b);
		Thread t3 = new Thread(threadDemo03c);
		
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName() + " " + this.name);
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.notifyAll();
		}
	}

}
