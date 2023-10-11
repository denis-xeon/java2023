package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        final int C3 = 1517 % 3;//String
        System.out.println("C3 = " + C3 + " /String");
        final int C17 = 1517 % 17;//В кожному реченні заданого тексту змінити місцями перше та останнє слово, не змінивши довжини речення.
        System.out.println("C17 = " + C17 + " /В кожному реченні заданого тексту змінити місцями перше та останнє слово, не змінивши довжини речення");

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Введіть текст: ");
            String text = scan.nextLine();
            if (text.isEmpty()) {
                System.out.println("Ви не ввели текст!");
            } else {
                String[] sentences = text.split("(?<=\\.|!|\\?)");
//                System.out.println(Arrays.toString(sentences));
                for (String sentence : sentences) {
                    sentence = sentence.trim();
                    char lastChar = ' ';
                    if (sentence.charAt(sentence.length() - 1) == '!' || sentence.charAt(sentence.length() - 1) == '?' || sentence.charAt(sentence.length() - 1) == '.') {
                        lastChar = sentence.charAt(sentence.length() - 1);
                    }
                    String[] words = sentence.split("[.?!\\s]+");
                    if (words[0].endsWith(",")) {
                        words[0] = words[0].substring(0, words[0].length() - 1);
                        words[words.length - 1] += ',';
                    }
                    String finalSentence = words[words.length - 1] + " ";
                    for (int j = 1; j < words.length - 1; j++) {
                        finalSentence += words[j] + " ";
                    }
                    finalSentence += words[0] + lastChar;
                    System.out.println(finalSentence);
                }
                break;
            }
        }
    }
}
