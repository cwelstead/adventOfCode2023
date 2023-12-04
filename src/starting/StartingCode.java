package starting;

import java.io.File;
import java.util.Scanner;

public class StartingCode {

    public static void main(String[] args) {
        final int DAY = 0;
        String directory = "./src/day" + DAY + "/Day" + DAY + ".txt";
        
        File input = new File(directory);
        Scanner inputReader = null;
        
        try {
            inputReader = new Scanner(input);
        } catch (Exception e) {
            System.out.println("Directory is wrong!");
        }
        
        // problem dependent variables go here
        
        while (inputReader.hasNextLine()) {
            
        }
        
        inputReader.close();
    }

}