package day5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) {
        final int DAY = 5;
        String directory = "./src/day" + DAY + "/Day" + DAY + ".txt";
        
        File input = new File(directory);
        Scanner inputReader = null;
        
        try {
            inputReader = new Scanner(input);
        } catch (Exception e) {
            System.out.println("Directory is wrong!");
        }
        
        // problem dependent variables go here
        
        // reading seeds
        ArrayList<Long> seeds = new ArrayList<Long>();
        ArrayList<Long> seedRanges = new ArrayList<Long>();
        Map[] maps = new Map[7];
        
        String firstLine = inputReader.nextLine();
        Scanner fScnr = new Scanner(firstLine);
        fScnr.next();
        
        while (fScnr.hasNextLong()) {
            seeds.add(fScnr.nextLong());
            seedRanges.add(fScnr.nextLong());
        }
        //inputReader.nextLine();
        
        int idx = 0;
        while (inputReader.hasNextLine()) {
            inputReader.nextLine();
            inputReader.nextLine();
            System.out.println("New map: " + inputReader.nextLine());
            
            ArrayList<Long> dests = new ArrayList<Long>();
            ArrayList<Long> sources = new ArrayList<Long>();
            ArrayList<Long> ranges = new ArrayList<Long>();
            
            while (inputReader.hasNextLong()) {
                dests.add(inputReader.nextLong());
                sources.add(inputReader.nextLong());
                ranges.add(inputReader.nextLong());
                //System.out.println(ranges.get(ranges.size() - 1));
            }
            
            maps[idx] = new Map(dests, sources, ranges);
            idx++;
        }
        
        long minLoc = 1848591090;
        
        for (int i = 0; i < seeds.size(); i++) {
            for (long j = seeds.get(i); j < seeds.get(i) + seedRanges.get(i); j++) {
                long checked = j;
                for (Map m : maps) {
                    checked = m.sourceToDestination(checked);
                }
                
                if (checked < minLoc) minLoc = checked;
            }
            System.out.println(i + " completed");
        }
        
        System.out.println(minLoc);
        
        inputReader.close();
    }

}