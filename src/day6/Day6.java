package day6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) {
        final int DAY = 6;
        String directory = "./src/day" + DAY + "/Day" + DAY + ".txt";
        
        File input = new File(directory);
        Scanner inputReader = null;
        
        try {
            inputReader = new Scanner(input);
        } catch (Exception e) {
            System.out.println("Directory is wrong!");
        }
        
        // problem dependent variables go here
        String timeS = inputReader.nextLine();
        String distance = inputReader.nextLine();
        Scanner timeScnr = new Scanner(timeS);
        Scanner distScnr = new Scanner(distance);
        
        timeScnr.next();
        distScnr.next();
        long time = Long.parseLong(timeScnr.nextLine().replaceAll(" ", ""));
        long dist = Long.parseLong(distScnr.nextLine().replaceAll(" ", ""));
        
        long value = 0;
        
        for (long i = 0; i < time; i++) {
            if (i * (time - i) > dist) {
                value++;
            }
        }
        
        System.out.println(value);
        
        inputReader.close();
    }

}