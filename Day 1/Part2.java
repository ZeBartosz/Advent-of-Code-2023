/* 
 * Advent of Code
 *      2023
 *      Day 1
 *     Part 2/2
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Part2 {

    public static List<Character> numbers = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    private final static Map<String, String> numberMap = Map.of("one", "one1one", "two", "two2two",
            "three", "three3three", "four", "four4four", "five", "five5five",
            "six", "six6six", "seven", "seven7seven", "eight", "eight8eight", "nine", "nine9nine");

    private static String digitChecker(String input) {
        String changedInput = input;
        // go through every entry in numberMap
        for (Map.Entry<String, String> entry : numberMap.entrySet()) {
            // Replace the key with the value in the string
            changedInput = changedInput.replace(entry.getKey(), entry.getValue());
        }
        return changedInput;
    }

    public static String FinalNumbers(String input) {
        String firstNum = null;
        String lastNum = null;

        var sentence = digitChecker(input);

        for (int i = 0; i <= sentence.length() - 1; i++) {
            if (numbers.contains(sentence.charAt(i)) && firstNum == null) {
                firstNum = String.valueOf(sentence.charAt(i));
            }

            int lastNumIndex = (sentence.length() - 1) - i;
            if (numbers.contains(sentence.charAt(lastNumIndex)) && lastNum == null) {
                lastNum = String.valueOf(sentence.charAt(lastNumIndex));
            }

        }
        System.err.println(firstNum + lastNum);
        return firstNum + lastNum;
    }

    public static void main(String[] args) throws FileNotFoundException {

        boolean realData = true;
        File file = null;
        if (realData) {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 1/PuzzelInput.txt");
        } else {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 1/Example2.txt");
        }
        Scanner line = new Scanner(file);

        int total = 0;
        while (line.hasNextLine()) {
            String input = line.nextLine();
            total += Integer.valueOf(FinalNumbers(input));

        }

        line.close();
        System.out.println(total);
    }

}