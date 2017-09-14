import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mlv on 14.09.2017.
 */
public class Reflection {

    //http://www.quizful.net/post/java-reflection-api

    public void ref(Integer integer) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class seller = integer.getClass(); //беремо клас
        Constructor[] construct = seller.getDeclaredConstructors(); // беремо конструктори із даниго класа
        Integer newObgect = (Integer) construct[0].newInstance("Параметри", "якщо вони є"); //створ. новий обєкт
        Method method = seller.getMethod("getShowCount"); // отримуємо потрібний нам метод//
        Field[] publicFields = seller.getFields(); // отримуємо масив полів
        Integer d = (Integer) method.invoke(integer, "Параметри"); //викликаємо метод в старого об'єкта
        Integer f = (Integer) method.invoke(newObgect, "Параметри");// викликаємо метод в нового об'єкта
    }
}
