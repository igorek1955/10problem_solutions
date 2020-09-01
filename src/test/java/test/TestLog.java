package test;


public class TestLog {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "ape", "asdfasdfasdfasdfasdfasdfasdfadsfasdf"};
        System.out.printf("%-15s %s\n", "Word", "Length");
        for (String word : words)
            System.out.printf("%-15.15s %s\n", word, word.length());
    }
}


