package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
Їбанутий валідатор не пропускає

*/
public class Solution
{
    public static void main(String[] args)
    {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = new  File ("/home/ant/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/file.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.equals(ivanov));
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();
        public Human() {
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }
        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            int result = assets.size();
            if (result > 0) {
                for (Asset a : assets) {
                    printWriter.println(a.getName());
                    printWriter.println(a.getPrice());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            name = bufferedReader.readLine();
            while (bufferedReader.ready()) {
                Asset asset = new Asset(bufferedReader.readLine());
                asset.setPrice(Double.parseDouble(bufferedReader.readLine()));
                assets.add(asset);
            }


        }
    }
}
