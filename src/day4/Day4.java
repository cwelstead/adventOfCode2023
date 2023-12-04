package day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) {
        final int DAY = 4;
        String directory = "./src/day" + DAY + "/Day" + DAY + ".txt";
        
        File input = new File(directory);
        Scanner inputReader = null;
        
        try {
            inputReader = new Scanner(input);
        } catch (Exception e) {
            System.out.println("Directory is wrong!");
        }
        
        // problem dependent variables go here
        int totalCopies = 0;
        int[] cardCopies = new int[213];
        for (int i = 0; i < cardCopies.length; i++) {
            cardCopies[i] = 1;
        }
        int currCardIdx = 0;
        
        while (inputReader.hasNextLine()) {
            Scanner lineReader = new Scanner(inputReader.nextLine());
            lineReader.next();
            lineReader.next();
            
            ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
            ArrayList<Integer> hasNumbers = new ArrayList<Integer>();
            
            while (lineReader.hasNextInt()) {
                winningNumbers.add(lineReader.nextInt());
            }
            lineReader.next();
            while (lineReader.hasNextInt()) {
                hasNumbers.add(lineReader.nextInt());
            }
            
            int winners = 0;
            for (Integer w : winningNumbers) {
                if (hasNumbers.contains(w)) winners++;
            }
            
            for (int i = 0; i < winners; i++) {
                cardCopies[currCardIdx + 1 + i] += cardCopies[currCardIdx];
            }
            
            totalCopies += cardCopies[currCardIdx];
            currCardIdx++;
        }
        
        System.out.println(totalCopies);
        
        inputReader.close();
    }

}