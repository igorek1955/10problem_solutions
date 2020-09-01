package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        FileInputStream readfile = new FileInputStream(filename);
        int min = 200;
        while (readfile.available() > 0) {
            int i = readfile.read();
            if (i < min) min = i;
        }
        System.out.println(min);
        scanner.close();
        readfile.close();
    }
}
