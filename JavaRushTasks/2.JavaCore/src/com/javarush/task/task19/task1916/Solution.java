package com.javarush.task.task19.task1916;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();

        while (reader1.ready()) {
            file1.add(reader1.readLine());
        }

        while (reader2.ready()) {
            file2.add(reader2.readLine());
        }


        while (file1.size() > 0 && file2.size()>0) {
            String f1 = file1.get(0);
            String f2 = file2.get(0);
            if (f1.equals(f2)) {
                lines.add(new LineItem(Type.SAME, f1));
                file1.remove(0);
                file2.remove(0);
            } else if (file1.get(1).equals(f2)) {
                lines.add(new LineItem(Type.REMOVED, f1));
                file1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, f2));
                file2.remove(0);
            }
        }
        if(file1.size()>0){
            for(String s: file1) lines.add(new LineItem(Type.REMOVED,s));
        }

        if(file2.size()>0){
            for(String s: file2) lines.add(new LineItem(Type.ADDED,s));
        }
//        System.out.println(lines);


        reader.close();
        reader1.close();
        reader2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

//        @Override
//        public String toString() {
//            return "LineItem{" +
//                    "type=" + type +
//                    ", line='" + line + '\'' +
//                    '}'+'\n';
//        }
    }
}
