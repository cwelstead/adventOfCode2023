package day1;
import java.io.File;
import java.util.Scanner;

public class Day1 {
    public static final String[] NUMS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    // 54429 too low
    public static void main(String[] args) {
        File text = new File("./src/Day1.txt");
        Scanner textReader = null;
        int sum = 0;
        
        try {
            textReader = new Scanner(text);
        } catch (Exception e) {
            System.out.println("Error occured with file");
        }
        
        while (textReader != null && textReader.hasNextLine()) {
            String line = textReader.nextLine();
            if (sum < 1000) {
                System.out.println(lookForFirstDigit(line) + ", " + lookForLastDigit(line));
            }
            
            // First digit
            sum += 10 * lookForFirstDigit(line);
            
            // Last digit
            sum += lookForLastDigit(line);
        }
        
        System.out.println(sum);
    }

    public static int lookForFirstDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return Integer.parseInt(s.substring(i, i + 1));
            } else {
                for (int j = 0; j < NUMS.length; j++) {
                    if (s.indexOf(NUMS[j]) == i) {
                        return j;
                    }
                }
            }
        }
        
        return 0;
    }
    
    public static int lookForLastDigit(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                return Integer.parseInt(s.substring(i, i + 1));
            } else {
                for (int j = 0; j < NUMS.length; j++) {
                    if (s.lastIndexOf(NUMS[j]) == i) {
                        return j;
                    }
                }
            }
        }
        
        return 0;
    }
}
