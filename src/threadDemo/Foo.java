package threadDemo;

class Foo1 extends Thread {
    private int val;
    private static Object lock = new Object();

    public Foo1(int v) {
        val = v;
    }

    public void printVal(int v) {
        synchronized (lock) {
            while (true)
                System.out.println(v);
        }
    }

    public void run() {
        printVal(val);
    }
}

class SyncTest1 {


    public static void main(String args[]) {
        Foo1 f1 = new Foo1(1);
        f1.start();
        Foo1 f2 = new Foo1(3);
        f2.start();
    }
}