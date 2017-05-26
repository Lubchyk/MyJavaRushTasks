package com.javarush.task.task18.task1816;
/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Stream stream = new Stream(args[0]);
        new Thread( stream ).start();
    }
  public static class Stream implements Runnable {
        String file;
        public String[] alphabet = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        FileInputStream fileInputStream;
        public Stream(String file) throws FileNotFoundException {
            this.file = file;
            fileInputStream = new FileInputStream(file);
        }
         @Override
          public void run() {
              int date;
              int count = 0;
              try {
                  while (fileInputStream.available() > 0) {
                      date = fileInputStream.read();
                     if(checking((char)date)) count++;
                  }
              } catch (IOException e) {
              }
             try {
                 fileInputStream.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             System.out.println(count);
          }
          public boolean checking(char c) {
              boolean result = false;
              for (int i = 0; i < alphabet.length; i++) {
                  if (alphabet[i].equalsIgnoreCase( String.valueOf( c ) )) {
                      result = true;
                      break;
                  }
              }
              return result;
          }
        }
}*/
public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"d:\\_JavaRush\\_Test\\Dear Sir or Madam.txt"};

        try (FileReader fileReader = new FileReader(args[0])) {
            int symbol;
            int count = 0;
            while ((symbol = fileReader.read()) != -1) {
                if (symbolIsEnglishLetter(symbol)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean symbolIsEnglishLetter(int symbol) {
        return (symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z');
    }
}
