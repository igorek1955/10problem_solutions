package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            Solution.lines = Files.readAllLines(Paths.get(Statics.FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8).forEach(l -> Solution.lines.add(l));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            while(reader.ready()){
                String l = reader.readLine();
                System.out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//            StringBuilder sb = new StringBuilder();
//            BufferedInputStream reader = new BufferedInputStream (new FileInputStream(FILE_NAME));
//            while(reader.available()>0 ) {
//                char ch = (char)reader.read();
//                if(ch == '\r'){
//                    Solution.lines.add(sb.toString());
//                    sb.delete(0, sb.length());
//                    continue;
//                }
//                sb.append(ch);
//            }
//            Solution.lines.add(sb.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        Statics st = new Statics();
        System.out.println(lines);
    }
}
