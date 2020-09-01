package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(!args[0].isEmpty()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith(args[0] + " ")) {
                    System.out.println(line);
                }
            }
            reader.close();
            bufferedReader.close();
        }
    }
}
