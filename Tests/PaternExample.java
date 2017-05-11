import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by АНТ on 11.03.2017.
 */
public class PaternExample {

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




/** Queue - коллекция, предназначенная для хранения элементов в порядке, нужном для их обработки.*/
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


}
