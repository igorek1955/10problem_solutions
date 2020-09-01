package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        List<String> strings = new ArrayList<>();
        while(reader.ready()){
            strings.add(reader.readLine());
        }
        reader.close();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        StringBuilder sb = new StringBuilder();
        for(String s: strings){
            String d = s.replaceAll("[A-Za-zА-Я-а-я]+","").trim();
            if(d.length()<10){
                sb.delete(0,sb.length());
                String[] p = s.split(" ");
                for(int i = p.length-3; i < p.length; i++){
                    if(p[i].length()==1) sb.append("0").append(p[i]).append(' ');
                    else sb.append(p[i]).append(' ');
                    d = sb.toString();
                }
            }
            String name = s.replaceAll("\\d+","").trim();
            Date date = formatter.parse(d);
            PEOPLE.add(new Person(name,date));
        }

//        PEOPLE.forEach(System.out::println);
    }
}
