package test;


import java.util.stream.Stream;

public class Threads {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();

        // Adding elements in the stream of Strings
        Stream<String> stream = builder.add("Geeks").build();

        // Displaying the elements in the stream
        stream.forEach(System.out::println);
    }

//    public static int solution(int number) {
//
//    }
}


