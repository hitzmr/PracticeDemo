/**
 * wait用法
 * @author DreamSea 
 * @time 2015.3.9 
 */
package threadDemo.alternatingPrint;

public class MainTest implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private MainTest(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.print(name);
					count--;

					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		MainTest pa = new MainTest("A", c, a);
		MainTest pb = new MainTest("B", a, b);
		MainTest pc = new MainTest("C", b, c);

		new Thread(pa).start();
		Thread.sleep(100); // 确保按顺序A、B、C执行
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}
}
