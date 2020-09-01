package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        int[] ints = new int[256];
        while(reader.available()>0){
            ints[reader.read()]+=1;
        }

        for (int i = 1; i < ints.length; i++) {
            if(ints[i]!=0){
                System.out.printf("%c %d%n", (char)i, ints[i]);
            }
        }
        reader.close();
    }
}
