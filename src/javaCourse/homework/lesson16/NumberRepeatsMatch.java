package javaCourse.homework.lesson16;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberRepeatsMatch {

    public static void main(String[] args) {
        System.out.println(hasNumberRepeatsMatch("1234303"));
        System.out.println(hasNumberRepeatsMatch("0001112"));
        System.out.println(hasNumberRepeatsMatch("4444"));
        System.out.println(hasNumberRepeatsMatch("111"));
    }

    public static boolean hasNumberRepeatsMatch(String input) {
        List<Character> charsList = input.chars()
                .mapToObj(c -> (char) c)
                .toList();

        Map<Character, Long> numCounts = charsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return numCounts.entrySet().stream()
                .anyMatch(entry -> {
                    char numChar = entry.getKey();
                    long count = entry.getValue();
                    int num = Character.getNumericValue(numChar);
                    return num == count;
                });
    }

}
