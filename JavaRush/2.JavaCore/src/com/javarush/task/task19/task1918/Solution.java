package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(rd.readLine()));
        StringBuilder sb = new StringBuilder();
        String tag = args[0];
        while(reader.ready()){
            sb.append(reader.readLine());
        }

        rd.close();
        reader.close();

        TreeMap<Integer,String> map = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();

        Matcher m = Pattern.compile("</?"+tag+".*?>").matcher(sb);
        while (m.find()){
            if (m.group().matches("<"+tag+".*?")) stack.push(m.start());
            if (m.group().matches("</"+tag+">")) {
                int begin = stack.pop();
                map.put(begin,sb.substring(begin,m.end()));
            }
        }

        for(Map.Entry<Integer, String> pair: map.entrySet()){
            System.out.println(pair.getValue());
        }

//        String open = "<"+args[0];
//        String close = "</"+args[0]+">";
//        List<String> strings = new ArrayList<>();

//        String[] rows = sb.toString().split(close);
//
//        for(int i = 0; i < rows.length; i++){
//            int start = rows[i].indexOf(open);
//            if(start>=0){
//                String[] opens = rows[i].substring(start).split(open);
//                System.out.println(Arrays.toString(opens));
//                if(opens.length<=2){
//                    strings.add(rows[i].substring(start)+close);
//                } else {
//                    strings.add(rows[i].substring(start).trim()+close+rows[i+1].trim()+close);
//                    strings.add(open+opens[2].trim()+close);
//                    i++;
//                }
//            }
//        }

    }
}
