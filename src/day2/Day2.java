package day2;

import java.io.File;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        File input = new File("./src/day2/Day2.txt");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(input);
        } catch (Exception e) {
            
        }
        
        int currID = 1;
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        final int MAX_BLUE = 14;
        final String[] COLORS = {"red", "green", "blue"};
        
        int sumPowers = 0;
        
        while (fileReader.hasNextLine()) {
            String game = fileReader.nextLine();
            game = game.substring(game.indexOf(":") + 2);
            Scanner gameReader = new Scanner(game);
            
            int minReds = 0;
            int minGreens = 0;
            int minBlues = 0;
            
            while(gameReader.hasNext()) {
                int pulledCubes = gameReader.nextInt();
                String color = gameReader.next();
                
                if (color.indexOf("red") >= 0 && pulledCubes > minReds) {
                    minReds = pulledCubes;
                } else if (color.indexOf("blue") >= 0 && pulledCubes > minBlues) {
                    minBlues = pulledCubes;
                } else if (color.indexOf("green") >= 0 && pulledCubes > minGreens) {
                    minGreens = pulledCubes;
                }
            }
            
            sumPowers += (minReds * minGreens * minBlues);
        }
        
        System.out.println(sumPowers);
    }

}
