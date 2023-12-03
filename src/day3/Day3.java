package day3;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) {
        File input = new File("./src/day3/Day3.txt");
        Scanner inputScnr = null;
        try {
            inputScnr = new Scanner(input);
        } catch (Exception e) {
            System.out.println("Can't");
        }
        
        ArrayList<String> inputList = new ArrayList<String>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        ArrayList<GridNumber> numsInContext = new ArrayList<GridNumber>();
        int row = 0;
        int currNumIndex = 0;
        int currNumColumn = 0;
        while (inputScnr.hasNextLine()) {
            String line = inputScnr.nextLine();
            
            for (int i = 0; i < line.length(); i++) {
                try {
                    Integer nextNum = Integer.parseInt(line.substring(i, i + 1));
                    if (currNumIndex == numList.size()) {
                        numList.add(nextNum);
                        currNumColumn = i;
                    } else {
                        numList.set(currNumIndex, numList.get(currNumIndex) * 10 + nextNum);
                    }
                    if (i + 1 == line.length()) {
                        numsInContext.add(new GridNumber(row, currNumColumn, numList.get(currNumIndex++)));
                    }
                    
                } catch (Exception e) {
                    if (currNumIndex == numList.size() - 1) {
                        numsInContext.add(new GridNumber(row, currNumColumn, numList.get(currNumIndex++)));
                    }
                }
            }
            
            inputList.add(line);
            row++;
        }
        
        int sum = 0;
        
        for (int i = 0; i < numsInContext.size(); i++) {
            for (int j = i + 1; j < numsInContext.size() && numsInContext.get(j).row - numsInContext.get(i).row <= 2; j++) {
                Point gear1 = checkAdjacent(inputList, numsInContext.get(i));
                Point gear2 = checkAdjacent(inputList, numsInContext.get(j));
                
                if (gear1 != null && gear2 != null && (int)gear1.getX() == (int)gear2.getX() && (int)gear1.getY() == (int)gear2.getY()) {
                    System.out.println("Gear: " + numsInContext.get(i).value + ", " + numsInContext.get(j).value);
                    sum += numsInContext.get(i).value * numsInContext.get(j).value;
                }
            }
        }
        
        System.out.println(sum);
    }

    public static Point checkAdjacent(ArrayList<String> list, GridNumber g) {
        for (int row = g.row - 1; row <= g.row + 1; row++) {
            for (int col = g.col - 1; col <= g.col + g.digitNumber; col++) {
                if (row >= 0 && row < list.size() && col >= 0 && col < list.get(row).length()) {
                    try {
                        int testInt = Integer.parseInt(list.get(row).substring(col, col + 1));
                    } catch (Exception e) {
                        if (list.get(row).substring(col, col + 1).equals("*")) {
                            //System.out.print(g.value + ", ");
                            return new Point(row, col);
                        }
                    }
                }
            }
        }
        
        return null;
    }
}
