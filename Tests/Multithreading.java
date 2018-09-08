import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mlv on 21.03.2017.
 */
public class Multithreading {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    /**
     * приклад як запустити другий потік
     */
    public static class TestThread implements Runnable {
        // закоментовані строки пишуться в головному потоці main
        //TestThread task = new TestThread();
        // new Thread(task).start();
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }

    /**
     * другий варіант того що вище
     */
    public static class TestThread2 extends Thread {
        public static volatile boolean S = false; /**volatile означає що перемінна S  для усіх потоків буде одна і та сама,
         1а не для кожного різна*/

//        // закоментовані строки пишуться в головному потоці main
//        TestThread thread = new TestThread();
//        thread.start();
        /* thread.join(); */

        /**
         * - команда: чекати повного виконання і завершення потоку thread
         */

        public void run() {
            synchronized (this) { /**Синхронізація! ставить монітор який блокує користуванням цього блоку усім потокам,
             окрім першого, який сюда потрапив і до того часу поки він не вийде інші потоки не зайдуть*/
                //  synchronized(TestThread2.class) {...} так блоується цілий клас
                setPriority(Thread.MAX_PRIORITY);/** задаю пріорітет даному потоку*/
                getPriority();/**отримую пріоритет потоку*/
                System.out.println("it's a run method");
                Thread.currentThread().getName();/**Так звертаємося до поточного потоку */
                Thread.yield();/**Передає управління іншому потоку в даному кванті часу, а слідуючий квант даного потоку
                 почнеться зразу після даної строки*/
                try {
                    Thread.sleep(0);/** аналогічно стрці  Thread.yield();*/
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = "5";
            synchronized (s) {        /** блокуємо тільки даний участок і перемінну  s */
                System.out.println(s);
            }
        }
    }

    /**
     * приклад того як робити павзу на 1 секунду
     */
    public static void pause() throws InterruptedException {
        Thread.sleep(1000);
    }


    /**
     * ногда в Java встречается ситуация, когда нужно унаследовать класс от нескольких классов.
     * Т.к. множественное наследование классов в Java запрещено, эту проблему решают с помощью внутренних классов:
     * в нужном нам классе мы объявляем внутренний класс и наследуем его от требуемого класса. Пример:
     */
    class Tiger extends Example.Cat {
        public void tigerRun() {
            //.....
        }

        public void startTiger() {
            thread.start();
        }

        private TigerThread thread = new TigerThread();

        private class TigerThread extends Thread {
            public void run() {
                tigerRun();
            }
        }
    }

    /**
     * приклади роботи із ThreadPoolExecutor
     */
    public static void method() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(5); //створює тред пул екзекютор

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable() { //виконує задачу
                @Override
                public void run() {
                    doExpensiveOperation(atomicInteger.incrementAndGet());
                }
            });
        }
        executorService.shutdown(); // забороняє додавати ще задачі
        executorService.awaitTermination(5, TimeUnit.SECONDS); // ставить ліміт часу на виконання
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }

    public static void method(int args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue();
        for (int i = 0; i < 15; i++) {
            linkedBlockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(atomicInteger.incrementAndGet());
                }
            });
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, linkedBlockingQueue);
        threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
/**
 * так можна перехоплювати exception із іншого потоку
 */
class Solution extends Thread {

    public Solution() {
    }
    @Override
    public void run() {
        super.run();
        int a = 5 / 0;
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) System.out.println("Нельзя дальше работать");
                else if (e instanceof Exception) System.out.println("Надо обработать");
                else if (e instanceof Throwable) System.out.println("Поживем - увидим");
            }
        });
        solution.start();
    }
}

