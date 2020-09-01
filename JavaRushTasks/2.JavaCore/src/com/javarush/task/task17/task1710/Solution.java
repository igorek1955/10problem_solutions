package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter oldFormat = DateTimeFormatter.ofPattern( "dd/MM/yyyy" , Locale.UK );
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern( "dd-MMM-yyyy" , Locale.UK );
        DateTimeFormatter defaultFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");



        if(args[0].equals("-c")){

            String date = LocalDate.parse(args[3], oldFormat).format(newFormat);
            Date newDate = sdf.parse(date);

            if(args[2].equals("м")){

                Person person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));

                System.out.println(sdf.format(person.getBirthDate()));

            }else{

                Person person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));

            }

        } else if(args[0].equals("-u")){
            String date = LocalDate.parse(args[4], oldFormat).format(newFormat);
            Date newDate = sdf.parse(date);
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(args[2]);
            allPeople.get(id).setBirthDate(newDate);
            if(args[3].equals("m")) allPeople.get(id).setSex(Sex.MALE);
            else allPeople.get(id).setSex(Sex.FEMALE);
        } else if(args[0].equals("-d")){
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDate(null);
            allPeople.get(id).setSex(null);


        } else if(args[0].equals("-i")){
            int id = Integer.parseInt(args[1]);
            String name = allPeople.get(id).getName();
            String oldBd = allPeople.get(id).getBirthDate().toString();
            String date = LocalDate.parse(oldBd, defaultFormat).format(newFormat);
            Sex sex = allPeople.get(id).getSex();
            String s;
            if(sex.toString().equals("MALE")) s="м";
            else s="ж";
            System.out.println(name + " " + s + " " + date);
        }
    }
}
