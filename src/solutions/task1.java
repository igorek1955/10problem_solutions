package solutions;

import java.util.ArrayList;
import java.util.List;

public class task1 {

    public static void main(String[] args) {
        first();
        second();
    }

    public static void first(){
        // TODO: ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        List<Person> people = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            people.add(new Person(1991+i,1+i,1+i, "Igor"+i, "Pupkin"+i));
        }

        String[] age = new String[people.size()];
        for(int i = 0; i < people.size(); i++){
            age[i] = (String.valueOf(people.get(i).birthDate.year)) +
                    (String.valueOf(people.get(i).birthDate.month)) +
                    (String.valueOf(people.get(i).birthDate.year));
            System.out.println(age[i]);
        }


    }

    public static void second(){
        // TODO: ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

    }
}

class Name {
    String firstName;
    String lastName;
}

class BirthDate {
    int year;
    int month;
    int day;
}

class Person {
    Name name;
    BirthDate birthDate;

    public Person(int year, int month, int day, String first, String last){
        this.birthDate.year = year;
        this.birthDate.month = month;
        this.birthDate.day = day;
        this.name.firstName = first;
        this.name.lastName = last;
    }
}