package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        while(reader1.ready()){
            String[] strings = reader1.readLine().split("\\s");

            for(String s: strings){
                if(s.matches("\\d*")){
                    writer.write(s+" ");
                }
            }
        }
        reader.close();
        writer.flush();
        writer.close();
        reader1.close();
    }
}
