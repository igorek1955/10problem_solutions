package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> filesList = new TreeMap<>();
        String fileName = br.readLine();
        String fileToSave = null;
        if (!fileName.equals("end")) fileToSave = fileName.split(".part")[0];
        while (!fileName.equals("end")){
            int n = Integer.parseInt(fileName.split(".part")[1]);
            filesList.put(n, fileName);
            fileName = br.readLine();
        }
        br.close();



        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileToSave)));

        for (Map.Entry<Integer, String> element : filesList.entrySet()){
            System.out.println(element.getKey() + " " + element.getValue());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(element.getValue()));
            while (bis.available() > 0){
                bos.write(((int) bis.read()));
            }
            bis.close();
        }

        bos.flush();
        bos.close();
    }
}

