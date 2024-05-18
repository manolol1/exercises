/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            04
* Description:   Hangman game
*********************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;

public class EX_26_04_Hangman {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      final String[] ascii = new ASCII().hangman;
      
      System.out.println(ascii[0]); // print ascii text title
      
      String[] words = getWordList();
      
      System.out.println("\nPress Enter to start the game!");
      s.nextLine();
   }
   
   private static String[] getWordList() {
      final String[] defaultWords = {"tree", "penguin", "school", "programming", "java", "computer", "giraffe", "operating system"};
      final String fileName = "words.txt";
      
      // try reading wordlist (file) and return words as String[]
      try {
         File file = new File(fileName);
         Scanner s = new Scanner(file);
         
         ArrayList<String> words = new ArrayList<>();
         while (s.hasNextLine()) {
            String line = s.nextLine().trim();
            if (line.length() > 0) {
               words.add(line);
            }
         }
         
         System.out.println("Using " + fileName + " as wordlist.");
         return words.toArray(new String[words.size()]);
         
      } catch (Exception e) {
         System.out.println("No wordlist found. To use a custom wordlist, create a file named " + fileName + " in the same folder as the program. Words are seperated by linebreaks.");
         System.out.println("Using default wordlist.");
         return defaultWords;
      }
   }
}