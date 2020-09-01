package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        int count = 0;
        while(reader.ready()){
            String[] text = reader.readLine().split("\\W");
            for(String s: text){
                if(s.equals("world"))count++;
            }
        }
        System.out.println(count);
        br.close();
        reader.close();
    }
}
