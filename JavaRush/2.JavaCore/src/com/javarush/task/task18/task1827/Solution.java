package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        if(args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();

            //Получаем все id из файла
            List<Integer> idList = new ArrayList();
            String content;
            reader = new BufferedReader(new FileReader(file));
            while(reader.ready()) {
                content = reader.readLine();
                int id = Integer.parseInt(content.substring(0, 8).trim());
                idList.add(id);
            }
            reader.close();

            int max = Collections.max(idList);
            String id = String.format("%-8.8s", max + 1);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.8s", args[2]);
            String quantity = String.format("%-4.4s", args[3]);
            String result = id + productName + price + quantity;
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine();
            writer.write(result);
            writer.close();
        }
    }
}
