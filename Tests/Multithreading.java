/**
 * Created by mlv on 21.03.2017.
 */
public class Multithreading {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    /**приклад як запустити другий потік*/
    public static class TestThread implements Runnable {
        // закоментовані строки пишуться в головному потоці main
        //TestThread task = new TestThread();
       // new Thread(task).start();
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
    /** другий варіант того що вище*/
    public static class TestThread2 extends Thread {
//        // закоментовані строки пишуться в головному потоці main
//        TestThread thread = new TestThread();
//        thread.start();
        public void run() {
            System.out.println("it's a run method");
        }
    }
    /**приклад того як робити павзу на 1 секунду*/
    public static void pause() throws InterruptedException {
        Thread.sleep(1000);
    }
}
