package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(!args[0].isEmpty()){
            //читаем имя файла
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String filename = read.readLine();
            read.close();

            //открываем потоки чтения и записи
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            if(args[0].equals("-d")){

                //собираем все строки, которые НЕ будем удалять
                List<String> strings = new ArrayList<>();
                while(reader.ready()){
                    String line = reader.readLine();
                    strings.add(line);
                }
                strings.removeIf(s-> s.substring(0,8).trim().equals(args[1]));

                //записываем все строки кроме, той которую нужно удалить (и очищаем файл)
                for(String s: strings){
                    writer.write(s);
                    writer.newLine();
                }
            }else if(args[0].equals("-u")){
                //ищем строку, которую нужно заменить и копируем все строки в арэйлист
                List<String> strings = new ArrayList<>();
                while(reader.ready()){
                    String line = reader.readLine();
                    if (line.contains(args[1].trim())){
                        String id = String.format("%-8.8s",args[1]);
                        String productName = String.format("%-30.30s",args[2]);
                        String price = String.format("%-8.8s",args[3]);
                        String quantity = String.format("%-4.4s",args[4]);
                        line = id+productName+price+quantity;
                    }
                    strings.add(line);
                }

                //записываем все строки кроме, той которую нужно удалить (и очищаем файл)
                for(String s: strings){
                    writer.write(s);
                    writer.newLine();
                }
            }
            reader.close();
            writer.flush();
            writer.close();
        }
    }
}
