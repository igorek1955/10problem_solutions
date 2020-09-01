package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine();
        FileInputStream in = new FileInputStream(filepath);
        int max = 0;
        while (in.available() > 0) {
            int i = in.read();
            if (max < i) max = i;
        }
        in.close();
        System.out.println(max);
    }
}
