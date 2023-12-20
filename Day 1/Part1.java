/* 
 * Advent of Code
 *      2023
 *      Day 1
 *     Part 1/2
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    public static List<Character> numbers = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static String FinalNumbers(String sentence) {
        String firstNum = null;
        String lastNum = null;

        for (int i = 0; i <= sentence.length() - 1; i++) {
            if (numbers.contains(sentence.charAt(i)) && firstNum == null) {
                firstNum = String.valueOf(sentence.charAt(i));
            }

            int lastNumIndex = (sentence.length() - 1) - i;
            if (numbers.contains(sentence.charAt(lastNumIndex)) && lastNum == null) {
                lastNum = String.valueOf(sentence.charAt(lastNumIndex));
            }

        }

        return firstNum + lastNum;
    }

    public static void main(String[] args) throws FileNotFoundException {

        boolean realData = true;
        File file = null;
        if (realData) {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 1/PuzzelInput.txt");
        } else {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 1/Example.txt");
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