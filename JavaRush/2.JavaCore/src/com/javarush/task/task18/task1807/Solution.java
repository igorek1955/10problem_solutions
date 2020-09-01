package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream input = new FileInputStream(filename);

        int count =0;
        while(input.available()>0){
            int i = input.read();
            if(i==44) count++;
        }

        System.out.println(count);
        reader.close();
        input.close();
    }
}
