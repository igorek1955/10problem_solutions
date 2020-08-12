package solutions;

import java.util.ArrayList;
import java.util.List;

public class task1 {

    public static void main(String[] args) {
        first();
        second();
    }

    public static void first() {
        // TODO: ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            people.add(new Person(1991 + i, 1 + i, 1 + i, "Igor" + i, "Pupkin" + i));
        }

        String s = "";//для хранения числа в виде строки
        int min = 0; //для хранения самого низкого числа
        int fromString = 0; //для хранения числа из строки
        int indexOfPerson = 0;
        for (int i = 0; i < people.size(); i++) {
            s = (String.valueOf(people.get(i).year)) +
                    (String.valueOf(people.get(i).month)) +
                    (String.valueOf(people.get(i).day));
            fromString = Integer.parseInt(s);
            if(min == 0){
                min = fromString;
                indexOfPerson = i;
            }

            if(fromString<min){
                min = fromString;
                indexOfPerson = i;
            }
        }

        System.out.println(people.get(indexOfPerson).firstName);
    }


    public static void second() {
        // TODO: ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        int min = 5;
        int max = 100;
        int randomName = 0;
        int randomAge = 0;
        List<Person> people = new ArrayList<>();
        String[] names = {"igor", "vasia", "kolya", "veronika", "marina", "marfa", "olga", "olesya", "kilka", "vobla"};
        for (int i = 0; i < 9; i++){
            randomAge = (int)(Math.random() * (max - min + 1) + min);
            randomName = (int)(Math.random() * 10 + 1);
            String s = String.valueOf(randomAge);
            people.add(new Person(randomAge, names[randomName]));
        }

        people.forEach(s -> System.out.println(s.firstName + " " + s.age));

    // рандомная дата рождения
//        int year = 0;
//        int month = 0;
//        int day = 0;
//        for (int i = 0; i < 9; i++){
//            randomAge = (int)(Math.random() * (max - min + 1) + min);
//            randomName = (int)(Math.random() * 10 + 1);
//            String s = String.valueOf(randomAge);
//            year = Integer.parseInt(s.substring(0,3));
//            month = Integer.parseInt(s.substring(4,5));
//            day = Integer.parseInt(s.substring(6,s.length()-1));
//            people.add(new Person());
//        }



    }
}

class Name {
    public String firstName;
    public String lastName;
}

class BirthDate {
    int year;
    int month;
    int day;
}

class Person {
    Name name;
    BirthDate birthDate;
    int year;
    int month;
    int day;
    int age;
    String firstName;
    String lastName;

    public Person(int year, int month, int day, String first, String last) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.firstName = first;
        this.lastName = last;
    }

    public Person(int age, String first){
        this.age = age;
        this.firstName = first;
    }

//    public Person(int year, int month, int day, String first, String last){
//        BirthDate birth = new BirthDate();
//        this.birthDate.year = year;
//        this.birthDate.month = month;
//        this.birthDate.day = day;
//        this.name.firstName = first;
//        this.name.lastName = last;
//    }
//    public Person(String first){
//        this.name.firstName = first;
//    }

}