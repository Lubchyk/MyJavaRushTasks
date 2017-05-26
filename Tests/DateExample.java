import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by АНТ on 01.02.2017.
 */
public class DateExample {
    public static void main(String[] args) {
        isDateOdd("JANUARY 2 2020");
    }

    /**
     * рахує скільки днів пройшло від початку року до вказаного числа
     */
    public static boolean isDateOdd(String date) {
        long msDay = 24 * 60 * 60 * 1000; // = число при діленні на яке отримуємо кількість днів

        Date yearEnd = new Date(date);

        long nextYaer = yearEnd.getYear(); // беремо потрібний нам рік
        int year = (int) nextYaer;

        Date yearBigan = new Date(date);
        yearBigan.setHours(0);
        yearBigan.setMinutes(0); // встановлення часу вручну
        yearBigan.setSeconds(0);
        yearBigan.setDate(0);
        yearBigan.setMonth(0);
        yearBigan.setYear(year);

        long year1End = yearEnd.getTime(); //бере час початку року
        long year1Bigan = yearBigan.getTime(); //бере час вказаної дати
        long period = year1End - year1Bigan; // отримуємо правильний період
        int dayCount = ((int) (period / msDay)); // вираховує скільки днів в періоді
        System.out.println(dayCount);
        return true;
    }

    /**
     * показує дату у вказаному форматі, але дата свого формату не міняє
     */
    public void dateformat(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);//вказання фомату і локалізацію
        Date date1 = new Date(date);
        System.out.println(simpleDateFormat.format(date1));
        new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse("15/04/1990"); //надійний спосіб встановити дату із стрінги
    }

    /**Потоки вводу (робота із байтами) InputStream
     *(робота із символами) Reader
     * Потоки виведення (робота із байтами) OutputStream
     * (робота із символами) Writer*/

    /**
     * копіюємо файли
     */
    public void fileCopy() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\mlv\\Desktop\\55.txt")); // можна та зчитувати із файла цілі строки

        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(destinationFileName);
        java.io.FileOutputStream fileOutputStream1 = new java.io.FileOutputStream(destinationFileName, true);// дописуємо у файл, а не переписуємо його

        int count = 0;
        while (fileInputStream.available() > 0) { // available() повертає к-ть не прочитаних байтів
            int data = fileInputStream.read(); // читає один байт із файла

            byte[] d = new byte[5000];
            int data1 = fileInputStream.read(d); // а можна і так зчитати зразу цілий блок(масив байтів)
            fileOutputStream.write(d,0,data1);// і так правильно записати його, якщо його довжина менша ніж byte[5000]
            fileOutputStream.write(d);// або просто так, але тут не враховується кількість записів у byte[5000]

            fileOutputStream.write(data);   // записуємо прочитаний байт в новий файл
            fileOutputStream.flush(); // примусово записує у файл всі не записані байти не обов'язково(автомат. викон. перед close())
            count++;
            System.out.println((char) fileInputStream.read()); // дрокуємо отриманий файл
        }
        System.out.println("Скопировано байт " + count);
        fileInputStream.close(); // закриває поток вісля чого файл не доступний
        fileOutputStream.close();
    }
    /**записуємо строки у файл і виходимо фразою "exit" */
    public void fileWrite() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mlv\\Desktop\\55.txt"));
        String line;
        for (; true; ) {
            line = reader.readLine();
            if (!line.equals("exit")) {
                writer.write(line);
                writer.newLine();
            } else {
                writer.write(line);
                break;
            }
        }
        reader.close();
        writer.close();
    }
    /** то саме що і вище але інший спосіб*/
    public void fileWrite2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\mlv\\Desktop\\55.txt");
        String line;
        String spase = "\r\n"; // нова строка
        for (; true; ) {
            line = reader.readLine();
            if (!line.equals("exit")) {
                 fileOutputStream.write((line + spase).getBytes());
            } else {
                fileOutputStream.write((line + spase).getBytes());
                break;
            }
        }
        reader.close();
        fileOutputStream.close();
    }
    /** зчитує числа із файла і сортує */
    public void fileRead() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));

        List<Integer> list = new ArrayList<>();
        int data;
        while ((scanner.hasNextInt())) {
            data = scanner.nextInt();
            list.add(data);
        }
        int temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                System.out.println(list.get(i));
        }
        reader.close();
        scanner.close();

    } //C:\Users\mlv\Desk
    /** То саме що і на один вище але тільки через BufferedReader */
    public void fileRead2() throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2= new BufferedReader(new InputStreamReader(new FileInputStream(br1.readLine())));

        List<Integer> list = new ArrayList<>();
        String line;
        int data;
        while ((line = br2.readLine()) != null) {
            data = Integer.parseInt(line);
            list.add(data);
        }
        int temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                System.out.println(list.get(i));
        }
        br1.close();
        br2.close();
    }
    /** копіюємо символьний файл */
    public void copyText() throws IOException {
        FileReader reader = new FileReader("c:/data.txt");
        FileWriter writer = new FileWriter("c:/result.txt");
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }
        //закрываем потоки после использования
        reader.close();
        writer.close();
    }


    /** так можна виконувати переведення типів*/
    public static void printMainInfo(Object object) {
        if (object instanceof Movable) ((Movable) object).move();
    }
    static interface Movable {
        void move();
    }
    /** приклад як дозволяти створювати тільки один-єдиний обєкт класу в системі */
    public static class Singleton {
        private static Singleton instance;
        private Singleton() {
        }
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
                return instance;
            } else return instance;
        }
    }
    /** Приклад як відбувається делегування*/
    public class Delegirovanie extends FileOutputStream {

        private FileOutputStream fileOutputStream;

       public Delegirovanie(FileOutputStream fileOutputStream)  throws FileNotFoundException {
           super("C:/tmp/result.txt");
           this.fileOutputStream = fileOutputStream;
        }
        /**Делегування*/
        @Override
        public void write(int b) throws IOException {
            fileOutputStream.write( b );
        }


    }
    /** Два класа для регулярних виразів Pattern, Matcher */
    public void regex() {
        Pattern pattern = Pattern.compile( "[\\s]" ); // задає шаблон (зараз там пробіл) по якому буде проводитися перевірка
        Matcher matcher = pattern.matcher(" fg"); // фраза яка буде перевірятися
        boolean b = matcher.matches(); // якщо всі символи із фрази будуть у шаблоні то поверне true
        //http://info.javarush.ru/translation/2015/02/19/Регулярные-выражения-в-Java.html
        //https://www.youtube.com/watch?v=OBkDT25X_S8
                }


}