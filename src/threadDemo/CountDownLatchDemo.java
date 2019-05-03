package threadDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(5);
		System.out.println("Main thread start");
		for(int j=0; j<5;j++){
			new Thread(
					new Runnable(){
						public void run(){
							for(int i=0; i<5; i++){
								System.out.println("CurrentThread:"+Thread.currentThread());
							}
							countDownLatch.countDown();
						}
					}
					).start();
		}
		countDownLatch.await();
		System.out.println("Main thread end");
		
	}

	

}
