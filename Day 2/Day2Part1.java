/* 
 * Advent of Code
 *      2023
 *      Day 2
 *     Part 1/2
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {

    public static Integer GameID(String input){
        String gameID = input.substring(0, input.indexOf(":"));
        int number = Integer.valueOf(gameID.substring(gameID.indexOf(" ") + 1));
        
        return number;
    } 

    public static String[] GameList(String input){
        
        String sets = input.substring(input.indexOf(":") + 2);
        String games = sets.replace(";", ",");
        String[] gameList = games.split(", ");

        return gameList;
    }

    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        boolean realData = true;
        File file = null;
        if (realData) {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 2/PuzzelInput.txt");
        } else {
            file = new File("C:/Users/stach/Documents/OneDrive/Advent Of Code/2023/Day 2/Example.txt");
        }
        Scanner line = new Scanner(file);
        
        int total = 0;

        while (line.hasNextLine()) {
            String input = line.nextLine();
            //System.out.println(GameID(input));
            total += GameID(input);
            
            for (String a: GameList(input)){
                int number = Integer.valueOf(a.substring(0, a.indexOf(" ")));
                String colour = a.substring(a.indexOf(" "));
                
                //System.out.println(a);
                    if (number > 12 && colour.contains("red")){
                            total -= GameID(input);
                            break;
                        }

                    if (number > 13 && colour.contains("green")){
                            //System.out.println(GameID(input));
                            total -= GameID(input);
                            break;
                        }
                    
                    if (number > 14 && colour.contains("blue")){
                            //System.out.println(GameID(input));
                            total -= GameID(input);
                            break;
                        }


            }
            

        }

        line.close();
        System.out.println(total);
    }

}
