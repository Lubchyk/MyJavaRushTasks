import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/** task 1*/
public class Task1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Вкажіть розташування файла");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader( new FileReader(reader.readLine()) );
        Set<String> res = new HashSet<>(  );

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] date = line.split("\\s+");
            for (int i = 0; i < date.length; i++) {
                res.add( date[i].replaceAll("[^A-Za-zА-Яа-я0-9]", "") );
            }
        }
        reader.close();
        bufferedReader.close();
    }
    /** task 2*/
    public class Task2 {

        public void method(String arr[], Collection collection) {
            for (int i = 0; i < arr.length; i++) {
                collection.add( arr[i] );
            }
        }
    }
    /** task 3*/
    public static class IncrementSynchronize {
        private int value = 0;

        public synchronized int getNextValue1() {
            value++;
            return value;
        }

        public int getNextValue2() {
            synchronized (new Integer(value++)) {
                return value;
            }
        }

        public int getNextValue3 () {
                synchronized (this) {
                    value++;
                    return value;
                }
        }
    }
}
