package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            String[] strings = s.split(" ");
            String first = strings[1].trim();
            String middle = strings[2].trim();
            String last = strings[0].trim();
            String stringDate = strings[3]+strings[4]+strings[5];
            SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            Date date = new Date();
            try {
                date = format.parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(first, middle, last, date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
