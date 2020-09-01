package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import sun.security.pkcs11.wrapper.Functions;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filepath = reader.readLine();
        FileInputStream buffer = new FileInputStream(filepath);
        List<Integer> ints = new ArrayList<>();

        while(buffer.available()>0){
            ints.add(buffer.read());
        }


        reader.close();
        buffer.close();

        Map<Integer, Integer> intMap = new HashMap<>();
//        for(Integer i: ints){
//            intMap.put(i, intMap.getOrDefault(i, 0)+1);
//        }

        int count;
        for (int i = 0; i < ints.size(); i++) {
            count = Collections.frequency(ints, ints.get(i));
            intMap.put(ints.get(i),count);
        }


        int max = 0;
        List<Integer> maxs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> pair: intMap.entrySet()){
            System.out.println(pair);
            if(pair.getValue()>max) max = pair.getValue();
        }

        for(Map.Entry<Integer, Integer> pair: intMap.entrySet()){
            if(pair.getValue()==max) maxs.add(pair.getKey());
        }

        maxs.forEach(m -> System.out.print(m+" "));
    }
}
