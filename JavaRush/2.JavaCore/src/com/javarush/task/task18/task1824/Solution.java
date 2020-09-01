package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String filename = reader.readLine();
            try(FileInputStream input = new FileInputStream(filename)){
                input.close();
            } catch (FileNotFoundException e){
                System.out.println(filename);
                break;
            }

        }
    }
}
