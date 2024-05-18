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
      
      System.out.println("\nPress Enter to start the game!");
      s.nextLine();
      
      String[] words = getWordList();
      String correctWord = words[random(0, words.length - 1)].toUpperCase();
      String word = "";
      int mistakes = 0;
      
      // prepare initial String
      for (char ch : correctWord.toCharArray()) {
         if (Character.isLetter(ch)) {
            word +='_';
         } else {
            word += ch;
         }
         word += ' ';
      }
      word = word.trim().toUpperCase();
      
      char[] wordAr = word.toCharArray();
      char guess;
      
      System.out.println(String.valueOf(word));
      //System.out.println(correctWord);
      
      // game loop
      while (mistakes < 10) {
         clear();
         System.out.println(mistakes != 0 ? ascii[mistakes] : "");
         System.out.println(String.valueOf(wordAr));
         
         // get user input
         System.out.print("\nEnter your guess (one letter): ");
         try {
            guess = s.nextLine().toUpperCase().charAt(0);
         } catch(Exception e) {
            // could be caused by empty response (StringIndexOutOfBoundsException)
            System.out.println("Failed to parse guess. Press enter to try again");
            s.nextLine();
            continue;
         }
         
         // compare user input with correct word
         boolean correct = false;
         for (int i = 0; i < correctWord.length(); i++) {
            if (correctWord.charAt(i) == guess) {
               wordAr[i * 2] = guess;
               correct = true;
            }
         }
         
         if (!correct) {
            mistakes++;
         }
         
         // winning condition
         if (String.valueOf(wordAr).replaceAll(" ", "").equals(correctWord.replaceAll(" ", ""))) {
            clear();
            System.out.println("You WON!");
            System.out.println(correctWord + " is the correct word.");
            System.exit(0);
         }
      }
      
      clear();
      System.out.println(ascii[10]);
      System.out.println("You LOST!");
      System.out.println("The correct word was: " + correctWord);
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
   
   private static void clear() {
      System.out.print("\n".repeat(30));
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}