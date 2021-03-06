package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new  File("/home/ant/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/file.tmp");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("F");
            user.setMale(true);
            user.setLastName("G");
            user.setBirthDate(new Date(1998,7,17));
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < users.size(); i++) {
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getBirthDate());
                printWriter.println(users.get(i).getLastName());
                printWriter.println(users.get(i).isMale());
                printWriter.println(users.get(i).getCountry().getDisplayedName());
            }
            printWriter.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            JavaRush javaRush = new JavaRush();
            while (bufferedReader.ready()) {
                User user = new User();
                user.setFirstName(bufferedReader.readLine());
//                String s = bufferedReader.readLine();
                long d = Long.parseLong(bufferedReader.readLine());
                Date date = new Date(d);
                user.setBirthDate(date);
                user.setLastName(bufferedReader.readLine());
                user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                user.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
