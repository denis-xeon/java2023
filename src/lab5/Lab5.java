package lab5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Введіть текст: ");
            String inputText = scan.nextLine();
            if (inputText.isEmpty()) {
                System.out.println("Ви не ввели текст!");
            } else {
                Text text = processInputText(inputText);
                System.out.println(text.toString());
                break;
            }
        }
    }

    public static Text processInputText(String inputText) {
        // Заміна табуляцій та пробілів одним пробілом
        inputText = inputText.replaceAll("[\\t\\s]+", " ");

        // Розділити текст на речення з розділовими знаками
        String[] sentences = inputText.split("(?<=\\.|!|\\?)");
        Text text = new Text();

        for (String sentenceStr : sentences) {
            sentenceStr = sentenceStr.trim();
            char lastChar = ' ';
            if (sentenceStr.charAt(sentenceStr.length() - 1) == '!' || sentenceStr.charAt(sentenceStr.length() - 1) == '?' || sentenceStr.charAt(sentenceStr.length() - 1) == '.') {
                lastChar = sentenceStr.charAt(sentenceStr.length() - 1);
            }
            String[] words = sentenceStr.split("[.?!\\s]+");

            Sentence sentence = new Sentence();

            for (int j = 0; j < words.length; j++) {
                Word word = new Word();
                for (int k = 0; k < words[j].length(); k++) {
                    if (words[j].charAt(k) != ','){
                        Letter letter = new Letter(words[j].charAt(k));
                        word.addLetter(letter);
                    }else {
                        word.setPunctuation(new Punctuation(','));
                    }
                }
                sentence.addWord(word);
            }

            sentence.swapFirstAndLastWords();
            Word lastWord = sentence.getWords().get(sentence.getWords().size() - 1);
            lastWord.setPunctuation(new Punctuation(lastChar));

            text.addSentence(sentence);
        }
        return text;
    }
}
