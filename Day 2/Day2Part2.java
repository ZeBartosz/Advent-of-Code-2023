/* 
 * Advent of Code
 *      2023
 *      Day 2
 *     Part 2/2
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {

    public static Integer GameID(String input){
        String gameID = input.substring(0, input.indexOf(":"));
        int number = Integer.valueOf(gameID.substring(gameID.indexOf(" ") + 1));
        
        return number;
    } 

    public static String[] GameList(String input){
        
        String sets = input.substring(input.indexOf(":") + 2);
        String[] gameList = sets.split("; ");
          
        return gameList;
    }

    public static Integer power(String[] input ){
        int green = 0;
        int blue = 0; 
        int red = 0;
        int finalScore = 0;
        
        for (String a: input){
            for (String b: a.split(", ")) {
                //System.out.println(b);
                int number = Integer.valueOf(b.substring(0, b.indexOf(" ")));
                String colour = b.substring(b.indexOf(" "));

                if(number > green && colour.contains("green")){
                    green = number;
                    //System.err.println(" number for green: " + green);
                    
                }

                if(number > blue && colour.contains("blue")){
                    blue = number;
                    //System.err.println(" number for green: " + blue);
                }

                if(number > red && colour.contains("red")){
                    red = number;
                    //System.err.println(" number for green: " + red);
                }
            }
            
        }
        
        finalScore = green * blue * red;

        return finalScore;
    }

    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        boolean realData = true;
        File file = null;
        if (realData) {
            file = new File("C:\\Users\\stach\\OneDrive\\Documents\\OneDrive\\Advent Of Code\\2023\\Day 2\\PuzzelInput.txt");
        } else {
            file = new File("C:\\Users\\stach\\OneDrive\\Documents\\OneDrive\\Advent Of Code\\2023\\Day 2\\Example.txt");
        }
        Scanner line = new Scanner(file);
        
        int total = 0;

        while (line.hasNextLine()) {
            String input = line.nextLine();
            //System.out.println(GameID(input));
            //System.out.println(power(GameList(input)));
            total += power(GameList(input));
            }
            

        

        line.close();
        System.out.println(total);
    }
  
}
