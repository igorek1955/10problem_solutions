package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", "bin", new File("C:\\Users\\Igor\\Desktop\\"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();
            System.out.println(ivanov);

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(somePerson.equals(ivanov));
            your_file_name.deleteOnExit();
            System.out.println(somePerson);

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

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
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

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(this.name);
            writer.newLine();

            int asses_size = this.assets.size();
            writer.write(String.valueOf(asses_size));
            writer.newLine();
            for (Asset ass : this.assets) {
                writer.write(ass.getName());
                writer.newLine();
                writer.write(String.valueOf(ass.getPrice()));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> strings = new ArrayList<>();
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
            reader.close();
            this.name = strings.get(0);
            int asses = Integer.parseInt(strings.get(1));

            if (asses > 0) {
                for(int i = 2; i < strings.size(); i+=2 ){
                    String price = strings.get(i+1).replaceAll("[\"']","");
                    this.assets.add(new Asset(strings.get(i),Double.parseDouble(price)));
                }
            }

        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", assets=" + assets.toString() +
                    '}';
        }
    }
}
