package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //считываем название файлов с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());


        byte[] buffer = new byte[input.available()];
        while(input.available()>0){
            int count = input.read(buffer);
        }

        char[] chars = new char[buffer.length];
        int c = 0;
        for(Byte b: buffer) {
            chars[c] = (char)(byte)b;
            c++;
        }
        String a = new String(chars);

        String[] nums = a.split(" ");


        StringBuilder sb = new StringBuilder();
        for(String s: nums){
            sb.append(Math.round(Float.parseFloat(s))).append(" ");
        }


        byte[] bufferEnd = sb.toString().getBytes();

        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(reader.readLine()));
        writer.write(bufferEnd);

        reader.close();
        input.close();
        writer.flush();
        writer.close();

    }
}
