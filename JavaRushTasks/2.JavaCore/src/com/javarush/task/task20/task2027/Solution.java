package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//                {'h', 'o', 'm', 'e', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
                {'f', 'd', 'e', 'r', 'l', 'k', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j', 'o', 'e', 'e', 'j', 'j'},
                {'l', 'n', 'g', 'r', 'o', 'v', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "pmlpml");
        words.forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordlist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == s.charAt(0)) {
                        //horizontal normal
                        if (j + 1 < crossword[i].length) {
                            if (crossword[i][j + 1] == s.charAt(1)) {

                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i][j + k];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j, i);
                                        word.setEndPoint(j + s.length() - 1,i);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                        //horizontal reversed
                        else if (j - 1 > 0 && crossword[i][j - 1] == s.charAt(1)) {
                            if (crossword[i][j - 1] == s.charAt(1)) {
                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i][j - k];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j, i);
                                        word.setEndPoint( j - s.length() + 1,i);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                        //vertical normal
                        else if (i - 1 > 0 && crossword[i - 1][j] == s.charAt(1)) {
                            if (crossword[i - 1][j] == s.charAt(1)) {
                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i - k][j];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j, i);
                                        word.setEndPoint(j, i - s.length() + 1);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                        //vertical reversed
                        else if (i + 1 < crossword.length && crossword[i + 1][j] == s.charAt(1)) {
                            if (crossword[i + 1][j] == s.charAt(1)) {
                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i + k][j];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j, i);
                                        word.setEndPoint(j,i + s.length() - 1);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                        //diagonal normal
                        else if (i + 1 < crossword.length && j + 1 < crossword[i + 1].length && crossword[i + 1][j + 1] == s.charAt(1)) {
                            if (crossword[i + 1][j + 1] == s.charAt(1)) {
                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i + k][j + k];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j, i);
                                        word.setEndPoint(j + s.length() - 1,i + s.length() - 1);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                        //diagonal reversed
                        else if (i - 1 > 0 && j - 1 > 0 && crossword[i - 1][j - 1] == s.charAt(1)) {
                            if (crossword[i - 1][j - 1] == s.charAt(1)) {
                                sb.append(s.charAt(0));
                                sb.append(s.charAt(1));
                                try {
                                    for (int k = 2; k < s.length(); k++) {
                                        char ch = (char) crossword[i - k][j - k];
                                        sb.append(ch);
                                    }
                                    if (sb.toString().equals(s)) {
                                        Word word = new Word(s);
                                        word.setStartPoint(j,i);
                                        word.setEndPoint(j - s.length() + 1,i - s.length() + 1);
                                        wordlist.add(word);
                                        sb.delete(0, sb.length());
                                    }
                                } catch (Exception e) {
                                    sb.delete(0, sb.length());
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }

        return wordlist;
}

public static class Word {
    private String text;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Word(String text) {
        this.text = text;
    }

    public void setStartPoint(int i, int j) {
        startX = i;
        startY = j;
    }

    public void setEndPoint(int i, int j) {
        endX = i;
        endY = j;
    }

    @Override
    public String toString() {
        return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
    }
}
}
