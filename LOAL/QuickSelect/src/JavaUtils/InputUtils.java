package JavaUtils;

import java.util.Scanner;

public class InputUtils {
   /** 
      ask user to input an integer 
      @param lb lowerBound (inclusive)
      @param ub upperBound (inclusive)
      @param message printed before waiting for input
   */
   public static int intInput(int lb, int ub, String message) {
      Scanner s = new Scanner(System.in);
      return intInput(s, lb, ub, message);
   }
   
   /** 
      ask user to input an integer 
      @param s Scanner(System.in)
      @param lb lowerBound (inclusive)
      @param ub upperBound (inclusive)
      @param message printed before waiting for input
   */
   public static int intInput(Scanner s, int lb, int ub, String message) {
      int input;
      
      System.out.print(message);
      
      try {
         input = s.nextInt();
      } catch (Exception e) {
         System.out.println("Couldn't parse input. Try again!");
         System.out.println("Exception: " + e);
         s.next();
         return intInput(s, lb, ub, message);
      }
      
      if (input < lb || input > ub) {
         System.out.printf("Number must be in range %d - %d. Try again!\n", lb, ub);
         return intInput(s, lb, ub, message);
      }
      return input;
   }
   
   /** 
      ask user to input a String
      @param message printed before waiting for input
   */
   public static String stringInput(String message) {
      Scanner s = new Scanner(System.in);
      return stringInput(s, message);
   }
   
   /** 
      ask user to input a String
      @param s Scanner(System.in)
      @param message printed before waiting for input
   */
   public static String stringInput(Scanner s, String message) {
      String input;
      
      System.out.print(message);
      
      try {
         input = s.nextLine();
      } catch (Exception e) {
         System.out.println("Couldn't parse input. Try again!");
         System.out.println("Exception: " + e);
         s.next();
         return stringInput(s, message);
      }
      
      return input;
   }
}