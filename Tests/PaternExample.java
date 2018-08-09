import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by АНТ on 11.03.2017.
 */
public class PaternExample {
    private ArrayList<Integer> array;

    /**приклад реалізації шаблона Singleton з лінивою ініціалізацією(lazy initialization)*/
    public class Sun {
        private /*static*/ Sun instance;

        private Sun() {
        }
        public/*static*/ Sun getInstance() {
            if (instance == null) instance = new Sun();
            return instance;
        }
    }

    /**Как запретить модифицировать данные массива через геттер? Либо возвращать копию*/
    public final List<Integer> getArray1() {
        return new ArrayList<>(array);
    }
    /**либо оборачивать в иммутабельный адаптер*/
    public final List<Integer> getArray2() {
        return Collections.unmodifiableList(array);
    }



/** Queue - коллекция, предназначенная для хранения элементов в порядке, нужном для их обработки. (черга)*/
    public class Collections1 {
        private final Queue<String> orderQueue = new ConcurrentLinkedQueue<String>();
        // http://www.seostella.com/ru/article/2012/08/09/kollekcii-collections-v-java-queue.html
    }
    /**В интерфейси предназначенный для реализации упорядочивания объектов класса.
     * Его удобно использовать при сортировке упорядоченных списков или массивов объектов.*/
    public class Collection2 implements Comparable, Comparator {

        @Override
        public int compareTo(Object o) {
            return 0;
        }

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }

        //http://echuprina.blogspot.com/2012/02/comparable-comparator.html
    }


/**шаблон wrapper (decorator) використовується щоб доповнити функціонал новим і не перепис початковий клас
 * суть заключається в суть заключається в вкладанні декоратора в декоратор в результаті виконання буде перший клас +
 * всі вкладені декоратори. Ссхема наслідства [інтерфейс]-- {абстракний декоратор}--(класи декоратори)*/


    public interface InterfaceComponent {
        void doOperation();
    }
    class MainComponent implements InterfaceComponent {
        @Override
        public void doOperation() {
            System.out.print("World!");
        }
    }
    abstract class Decorator implements InterfaceComponent {
        protected InterfaceComponent component;

        public Decorator (InterfaceComponent c) {
            component = c;
        }
        @Override
        public void doOperation() {
            component.doOperation();
        }
        public void newOperation() {
            System.out.println("Do Nothing");
        }
    }
    class DecoratorSpace extends Decorator{

        public DecoratorSpace(InterfaceComponent c) {
            super(c);
        }
        @Override
        public void doOperation() {
            System.out.print(" ");
            super.doOperation();
        }
        @Override
        public void newOperation() {
            System.out.println("New space operation");
        }
    }
    class DecoratorComma extends Decorator {

        public DecoratorComma(InterfaceComponent c) {
            super(c);
        }
        @Override
        public void doOperation() {
            System.out.print(",");
            component.doOperation();
        }
        @Override
        public void newOperation() {
            System.out.println("New comma operation");
        }
    }
    class DecoratorHello extends Decorator {

        public DecoratorHello(InterfaceComponent c) {
            super(c);
        }
        @Override
        public void doOperation() {
            System.out.print("Hello");
            component.doOperation();
        }
        @Override
        public void newOperation() {
            System.out.println("New hello operation");
        }
    }
    //ВИКОНАННЯ програми
    class Main {
        public void main(String... s) {
            Decorator c = new DecoratorHello( new DecoratorComma( new DecoratorSpace( new MainComponent() ) ) );
            c.doOperation(); // Результат выполнения программы "Hello, World!"
             c.newOperation(); // New hello operation
        }

    }



}









