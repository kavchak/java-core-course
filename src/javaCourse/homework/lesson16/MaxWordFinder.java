package javaCourse.homework.lesson16;

import java.util.Arrays;
import java.util.Optional;

public class MaxWordFinder {

    public static void main(String[] args) {
        System.out.println(findMaxWord("I had lost my key"));
    }

    public static String findMaxWord(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleanedText.split("\\s+");

        Optional<String> maxWord = Arrays.stream(words)
                .reduce((longest, current) ->
                        current.length() > longest.length() ? current : longest
                );

        return maxWord.orElse("");
    }
}
