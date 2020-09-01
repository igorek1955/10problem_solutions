package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.List;

public class Solution {
    public static String firstFileName = "C:\\Users\\Igor\\Desktop\\test1.txt";
    public static String secondFileName = "C:\\Users\\Igor\\Desktop\\test2.txt";

    static{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileThread f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        System.out.println(f.getFileContent());
        f.join();
        f.join1();
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent() throws IOException;
        void join() throws InterruptedException, IOException;
        void start();
    }


    public static class ReadFileThread extends Thread implements  ReadFileInterface {
        String filename;
        String content = "";
        BufferedReader reader;



        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            if(reader!=null){
                while(reader.ready()){
                    this.content+=reader.readLine()+" ";
                }
            }
            return this.content;
        }


        public void join1() throws InterruptedException, IOException {
            if(reader!=null) reader.close();
            this.content="";
        }

        @Override
        public void start() {
            run();
        }

        @Override
        public void run() {
            {
                try {
                    reader = new BufferedReader(new FileReader(this.filename));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
