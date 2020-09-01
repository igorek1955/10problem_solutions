package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Deque<String> st = new ArrayDeque<>();
        st.add("s");
        st.push("s");
        st.pop();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader read1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        List<String> strings = new ArrayList<>();

        while(read1.ready()){
            strings.add(read1.readLine());
        }

        for(String s: strings){
            s = s.replaceAll("[.]+","!");
            writer.write(s);
            writer.newLine();
        }

        reader.close();
        read1.close();
        writer.flush();
        writer.close();
    }
}
