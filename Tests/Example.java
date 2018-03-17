import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by mlv on 10.01.2017.
 */
public class Example {
    /**reverse*/
    String line = "123";
    String reverse = new StringBuffer(line).reverse().toString();

    /** клас для роботи із пропертями*/
    public static Properties properties = new Properties();
    /** коротка форма if*/
    Object cat;
    String isCatPresent = cat != null ? "yes" : "no";

    /**створюємо файл*/
    File file = new File( "C:/Users/mlv/Desktop/Новая папка/Lion.avi.part1" ); //file.createNewFile();
    /** вводимо дані із клави варіант 1*/
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    String name = scanner.nextLine();
    static int s = 5;
    /** вводимо дані із клави варіант 2*/
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String q = reader.readLine();
    int f = Integer.parseInt(q);
    double e = Double.parseDouble(q);
    /** міняємо малі букви на великі */
    public void toUpperCase() {
        String s = "hfhf";
        s = s.toUpperCase();
    }
    /** Байти 32 пробіл 13 ентер 10 нова строка, Щоб записати в байтах використовуємо "25".getBytes()*/

    public Example() throws IOException {
    }
    /** вираховує парне і не парне число механізм слідуючий
     * бере отримане число і поміщає в нього двійку до того часу,
     * поки число не заповнеться, якщо остання двійка помістилася повністю отримаємо 0 і число відповідно було парне
     * якщо число не парне то остання 2 поміститься тільки на половину і ми отримаємо число 1*/
    public static void namber(int a) {

        int b = a % 2;
        if (a > 0 && a < 10 && b == 1) System.out.println("нечетное однозначное число");
        if (a > 0 && a < 10 && b == 0) System.out.println("четное однозначное число");

        if ((a > 0)) {
            b = a % 2;
            if (b == 0) System.out.println("положительное четное число");
            else if (b == 1) System.out.println("положительное нечетное число");
        }
        else if(a < 0) {
            b = a % 2;
            if (b == 0) System.out.println("отрицательное четное число");
            else if (b == -1) System.out.println("отрицательное нечетное число");
        }
        else if (a == 0) System.out.println("нулевое число");
    }
    /** Мшнімум із 2 чисел*/
    public static int update(int a, int  b) {
        if (a > b) return a;
        else return b;
    }
    /** приклади для if*/
    public static void  update(int a, int b, int c) {
        if (a > 50 && a < 100)
            System.out.println("Число " + a + " содержится в интервале.");
        else  System.out.println("Число " + a + " не содержится в интервале.");
        if ((a > (b + c)) || (b >(a + c)) || (c > (a + b))   ){
            System.out.println("Треугольник не существует.");
        }
        else System.out.println("Треугольник существует.");
    }

    /**приклад оператора switch  є в задачі JavaCore -- com.javarush.task.task17.task1711*/
    public static void swi_tch(String s) {
        switch (s) {
            case "5" : /*дія*/ break; // break не обов'язково
            case "6" : /*дія*/ break; // break не обов'язково
            case "7" : /*дія*/ break; // break не обов'язково
        }

    }
    /**порівняння довжини двох строк*/
    public static void  comparison(String name1, String name2) {
        if (name1.equals(name2)) System.out.println("Имена идентичны");
        else if (name1.length() == name2.length()) System.out.println("Длины имен равны");
    }
    /**цикл for*/
    public static void yaer(int yaer) {
        int a = 0;
        int x1 = 365;
        int x2 = 366;
        for (int i = 0; i < 2017; i = i + 4) {
            if (yaer == 1700 || yaer == 1800 || yaer == 1900 || yaer == 2100 || yaer == 2200 || yaer == 2300)
            {
                System.out.println("количество дней в году: " + x1);
                break;
            }
            if (yaer == i)
            {
                System.out.println("количество дней в году: " + 366);
                a = 1;
                break;
            }
        }
        if(a == 0){
            System.out.println("количество дней в году: " + 365); }
    }
    /** цикл while і приклад таблиці множення */
    public void  multiplicationTables() {
        int a = 1;
        while (true) {
            System.out.println(1 * a + " " + 2 * a + " " + 3 * a + " " + 4 * a + " " + 5 * a + " " + 6 * a + " " + 7 * a + " "
                    + 8 * a + " " + 9 * a + " " + 10 * a);
            a++;
            if (a > 10) {
                break;
            }
        }
        while (a < s) {
            System.out.println(a);
            a++;
        }
    }
    /** метод який вираховує відстань між двома точками*/
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double a = x1 - x2;
        a = a * a;
        double b = y1 - y2;
        b = b * b;
        double result = a + b;
        result = Math.sqrt(result);
        return result;
    }
    /**знаходить найдовші строки і дрокує їх */
    public  void  printMaxLength() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String b;
        String c = "";
        for (int i = 0; i < 5; i++) {
            String a = reader.readLine();
            list.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            b = list.get(i);
            if (b.length() > c.length()) c = b;
        }
        for (int i = 0; i < list.size(); i++) {
            b = list.get(i);
            if (b.length() == c.length())
                list2.add(b);
        }
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
    /**те саме що на один вище тільки по іншому принципу і знаходить самі менші строки */
    public void printMinLength() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min;
        for (int i = 0; i < 5; i++) {
            String a = reader.readLine();
            list.add(a);
        }
        min = list.get(0).length();
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i).length()) min = list.get(i).length();
        }
        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i).length()) System.out.println(list.get(i));
        }
    }
    /**приклад як коротко ініціалізувати ARRAYLISR
     * Як коротко перебігатися по ньому в циклі for
     * і як відловлювати букви (символи) із строки*/
    public void Array1() {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "роза", "лира", "лоза");
        for (int i = 0; i < list.size();) {
            if (list.get(i).contains("р") && !list.get(i).contains("л")) list.remove(i);
            else if (list.get(i).contains("л") && !list.get(i).contains("р"))
            { list.add(i, list.get(i));
                i+=2; }
            else if (list.get(i).contains("л") && list.get(i).contains("р")) i++;
            else i++;
        }
        for (String x : list)
        {
            System.out.println(x);
        }
    }
    /** приклад колекції MAP */
    public void hashMap() {
        Map<String, String> map = new TreeMap<String, String>(); // записує в себе дані у відсортованому порядку ключа
        Map<String, String> var = new HashMap<String, String>();
        var.put("арбуз","ягода");
        var.put("банан", "трава");
        Iterator<Map.Entry<String, String>> iterator = var.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
            iterator.remove();// так удаляємо пару
        }
        for (Map.Entry<String, String> pair : var.entrySet()) { /* ... */ }
    }
    /** приклад колекції SET */
    public void hashSet() {
        Set<String> var = new HashSet<String>();
        var.add("ирис");
        var.add("картофель");
        Iterator<String> iterator = var.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }
    /**Stack Trace*/
    public static String method1() {
        // method2();
        /**створює обєкт Stack Trace */
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        /**отримує клас із якого був викликаний*/
        StackTraceElement elements = stackTraceElements[2];
        String classs = elements.getClassName();
        /**отримує назву метода який викликав даний метод */
        String s = stackTraceElements[2].getMethodName();
        /**отримує номер строчки з якої був викликаний даний метод */
        int f = stackTraceElements[2].getLineNumber();
        /**отримує глибину стек трейса (кількість методів) */
        int g = stackTraceElements.length;
        /** перебіг в циклі*/
        String p = null ;
        System.out.println(stackTraceElements[0].getMethodName());
        for (StackTraceElement element : stackTraceElements) {
            p =  element.getMethodName();
        }
        /**скорочена форма перебігу по стеку і його друку*/
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
        return stackTraceElements[2].getMethodName();
    }
 /**визначаємо тип обєкта */
    public static void printObjectType(Object o) {
        if (o instanceof Cat) System.out.println("Кошка");
    }
    public static class Cat {
    }

    /**при вводі такої фрази пише всі перші букви із великої букви "  мама     мыла раму." */
    public static void firstLetterToUpper() throws IOException {
        List<String> space = new ArrayList<String>();
        String countSpace = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arr = s.toCharArray(); // переносимо строку в масив символів
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') { // шукаємо пробіли
                for (int j = i; j < arr.length; j++) { // рахуємо скільки пробілів є підряд
                    if (arr[i] != ' ') break;
                    countSpace = countSpace + " ";
                    i++;
                }
            }
            if (!countSpace.equals("")) {// записуємо пробіли в їх кількості в список
                space.add(countSpace);
                countSpace = "";
            }
        }
        s = s.trim();
        s.replaceAll( "[^a-zA-Z ]", "" ); // видаляє із строки все окрім букв і пробіл
        s.replaceAll( "[a-zA-Z]", "" ); // видаляє із строки всі букви
        String s1[] = s.split("\\s+"); // розбиває строку на декілька розділяє якщо знаходить в строці пробіл(и)
        //String[] words = s.split("[\\p{P} \\t\\n\\r]"); Как разбить строку на отдельные слова, игнорируя знаки препинания
        String bk1 = s1[0].substring(0, 1); // копіює вказаний символ із строки
        String bk2 = s1[1].substring(0, 1); // копіює вказаний символ із строки
        String bk3 = s1[2].substring(0, 1); // копіює вказаний символ із строки
        String sl1 = s1[0].substring(1, s1[0].length());
        String sl2 = s1[1].substring(1, s1[1].length());
        String sl3 = s1[2].substring(1, s1[2].length());
        bk1 = bk1.toUpperCase(); // переводить з малої до великої
        bk2 = bk2.toUpperCase(); // переводить з малої до великої
        bk3 = bk3.toUpperCase(); // переводить з малої до великої
        if (space.size() == 2) System.out.println(bk1 + sl1 + space.get(0) + bk2 + sl2 + space.get(1) + bk3 + sl3);
        //склеюємо першу велику букву строки + решта строки + склеюємо якщо пробіли повторюються 3 раза
        if (space.size() == 3)
            System.out.println(space.get(0) + bk1 + sl1 + space.get(1) + bk2 + sl2 + space.get(2) + bk3 + sl3);
        //склеюємо першу велику букву строки + решта строки + якщо пробіли повторюються 4 раза
        if (space.size() == 4)
            System.out.println(space.get(0) + bk1 + sl1 + space.get(1) + bk2 + sl2 + space.get(2) + bk3 + sl3 + space.get(3));
    }
    /**то саме що на один вище, але більш точно*/
    public static void firstLetterToUpperMethod2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        boolean upDone = false; // если увеличили первый символ слова

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && upDone) {
                upDone = false;
                continue;
            }
            if (s.charAt(i) == ' ')
                continue;
            if (s.charAt(i) != ' ' && !upDone) {
                s = s.substring(0, i) + ((s.substring(i, i + 1)).toUpperCase()) + s.substring(i + 1);
                upDone = true;
            }
        }
        System.out.println(s);
    }
    /**сортування слів у масиві по алфавіту */
    public static void sort(String[] array) {
        String[] alphabet = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"} ;
        int count = 0;
        for (int i = 0; i <alphabet.length ; i++) {
            for (int j = 0; j < array.length; j++) {

                String a = String.valueOf(array[j].charAt(0)); //витягує перший символ із строки в масиві

                if (alphabet[i].equalsIgnoreCase(a)) {

                    String temp = array[count];         //сортує

                    array[count] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
        }
    }
    // http://study-java.ru/uroki-java/urok-11-sortirovka-massiva/   - як сортувати масиви
    /**те саме що і на один вище, але системний метод*/
    public Array sort(Array array) {
        Arrays.sort(new Array[]{array});
        ArrayList<Integer> byteList = new  ArrayList<Integer>();
        Collections.sort(byteList);
       /**можна і так сортувати  --- */ // Collections.sort(list);
        return array;
    }
    /** метод передує, яка строка передує (тобто сортує строки за алфавітом)*/
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    /**вираховує чи строка число*/
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;  }
        }
        return true;
    }
    /**короткий запис вставляє замість %s перемінні*/
    public void print(String a, int b, boolean c) {
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена",
            a, b, c));
}
    /**короткий запис if*/
    public static int min(int a, int b) {
        return a < b ? a : b;
    }


    /**Большие числа в Java. Классы BigInteger и BigDecimal.*/
    public static void BigInteger() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.valueOf(2);
        BigInteger c = a.multiply(BigInteger.valueOf(5)); //множимо b на 5
        b = b.add(c); // додаємо

    }
    /** Так створюється перечислення констант*/
    enum  Type {
        A1, A2, A3
       //використовувати потім наприклад так Object d = Type.A1;
    }


}