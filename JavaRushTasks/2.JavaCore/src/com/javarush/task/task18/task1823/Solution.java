package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Thread> allthreads = new ArrayList<>();
        String filename = reader.readLine();
        while(!filename.equals("exit")){
            allthreads.add(new ReadThread(filename));
            filename = reader.readLine();
        }
        reader.close();

        Thread.sleep(2000);

        for(Thread t: allthreads){
            t.join();
        }
    }

    public static class ReadThread extends Thread {
        private String filename;
        private int max;

        public ReadThread(String fileName) {
            this.filename = fileName;
            this.start();
        }

        @Override
        public void run() {
            Map<Integer, Integer> freq = new HashMap<>();
            int max_count=1;
            try {
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(this.filename));
                while(reader.available()>0){
                    int i = reader.read();
                    freq.put(i, freq.getOrDefault(i, 0)+1);
                }

                reader.close();

                for(Map.Entry<Integer,Integer> pair: freq.entrySet()){
                   int i = pair.getValue();
                   if(i > max_count){
                       max_count = i;
                       max = pair.getKey();
                   }
                }

                resultMap.put(this.filename,this.max);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
