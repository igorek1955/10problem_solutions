package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.next();
        String file2 = scanner.next();
        scanner.close();

        FileInputStream reader1 = new FileInputStream(file1);
        FileInputStream reader2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[reader1.available()];
        byte[] buffer2 = new byte[reader2.available()];

        while (reader2.available()>0){
            int count1 = reader2.read(buffer2);
        }

        while (reader1.available()>0){
            int count2 = reader1.read(buffer1);
        }

        reader1.close();
        reader2.close();

        byte[] bigbuff = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer2, 0, bigbuff, 0, buffer2.length);
        System.arraycopy(buffer1, 0, bigbuff, buffer2.length, buffer1.length);

        FileOutputStream writer = new FileOutputStream(file1);
        writer.write(bigbuff,0,bigbuff.length);
        writer.close();
    }
}
